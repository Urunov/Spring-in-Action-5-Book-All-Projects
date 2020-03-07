package controller;

import lombok.extern.slf4j.Slf4j;
import model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {
    //
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order, Error errors) {
        if(errors.hasErrors()){
            return "orderForm";
        }

        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
