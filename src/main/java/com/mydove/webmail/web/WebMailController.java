package com.mydove.webmail.web;

import com.mydove.webmail.entity.User;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Stanislav Oginsky
 */
@Controller
public class WebMailController {
	
    @Resource(name = "imapProps") 
    private Properties props;
	
    @RequestMapping("/auth")
    public String authPage() {
        return "auth";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authorize(@ModelAttribute("user") User user,
            BindingResult result) {
    	String redirectPage = "auth";
        try {
            user.login(props);
            redirectPage = "main";
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(WebMailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(WebMailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return redirectPage;
    }
    
    @ModelAttribute("user")
    public User getUserObject() {
       return new User();
    }

    @RequestMapping("/index")
    public String mainPage(Map<String, Object> map) {
        map.put("user", new User());

        return "auth";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
}
