package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
    @RequestMapping(path = "/first", produces = "text/html; charset=UTF-8")
    public String first() {
        return "WEB-INF/views/first.jsp";
    }

    @RequestMapping(path = "/second", produces = "text/html; charset=UTF-8")
    public String second() {
        return "redirect:third";
    }

    @RequestMapping(path = "/third", produces = "text/html; charset=UTF-8")
    public String third() {
        return "WEB-INF/views/third.jsp";
    }
}
