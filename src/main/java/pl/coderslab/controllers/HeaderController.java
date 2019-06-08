package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {
    @RequestMapping(path = "/showUserAgent", produces = "text/html; charset=UTF-8")
    public String home(@RequestHeader("user-agent") String userAgent, Model model) {
        model.addAttribute("header", userAgent);
        return "WEB-INF/views/userAgent.jsp";
    }
}
