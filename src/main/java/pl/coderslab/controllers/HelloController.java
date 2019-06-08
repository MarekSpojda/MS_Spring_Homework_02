package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Controller
public class HelloController {
    @RequestMapping(path = "/workers", produces = "text/html; charset=UTF-8")
    public String workersAction(Model model) {
        int randomInt = (int) (Math.random() * 30) + 1;
        model.addAttribute("randomResult", randomInt);
        String toReturn = "(nikt, sorry:])";
        model.addAttribute("person", toReturn);
        try {
            InputStream inputStream = getClass()
                    .getClassLoader().getResourceAsStream("utils/Workers.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace(",", "");
                StringTokenizer stringTokenizer = new StringTokenizer(StringUtils.trimWhitespace(line), " ");
                String first = stringTokenizer.nextToken();
                String second = stringTokenizer.nextToken();
                String third = stringTokenizer.nextToken();
                int param = Integer.parseInt(first);
                if (randomInt == param) {
                    toReturn = second + " " + third;
                    model.addAttribute("person", toReturn);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "WEB-INF/views/workers.jsp";
    }
}
