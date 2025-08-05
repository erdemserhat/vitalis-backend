package com.vitalis.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String rootPresenter(){
        //Thymeleaf handles this operation no need to worry about,
        //If you add files resources/static/x.html and return "x" it will return x.hrml in specified endpoint
        return "vitalis";
    }
}
