package com.example.LibraryCMS.Controller;



import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/home")
    public String helloWorld(){
        return "home.html";
    }


}
