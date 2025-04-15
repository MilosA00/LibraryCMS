package com.example.LibraryCMS.Controller;



import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@org.springframework.stereotype.Controller
public class Controller {


    public String helloWorld(){
        return "index.html";
    }


}
