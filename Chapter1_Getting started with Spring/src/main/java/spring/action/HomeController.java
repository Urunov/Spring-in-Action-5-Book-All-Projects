package spring.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //
    @GetMapping("/taco")
    public String home(){
        return "home";
    }
}
/*
*  Return type is related resource folder, template/home.html
*  Temporarily using address, and not required fixed location.
* */