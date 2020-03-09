package spring.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @Created 09 / 03 / 2020 - 5:18 PM
 * @project SpringData
 * @Author Hamdamboy
 */

//tag::classShell[]
    @Controller
    @RequestMapping("/design")
    @SessionAttributes("order")

public class DesignTacoController {
    //
    //end::classShell[]

    //tag::bothRepositoryProperties[]
}
//https://github.com/habuma/spring-in-action-5-samples/blob/master/ch03/tacos-jdbc/src/main/java/tacos/web/DesignTacoController.java