package com.mvc.assignment;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Handle the error as you wish, e.g., redirect to a custom error page
        return "error"; // Assuming you have an "error.html" template in your templates directory
    }

    public String getErrorPath() {
        return "/error";
    }
}
