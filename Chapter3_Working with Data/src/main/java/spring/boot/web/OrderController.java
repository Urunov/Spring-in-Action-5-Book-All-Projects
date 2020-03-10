package spring.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import spring.boot.Order;
import spring.boot.data.OrderRepository;

import javax.validation.Valid;

/**
 * @Created 09 / 03 / 2020 - 5:19 PM
 * @project SpringData
 * @Author Hamdamboy
 */

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")

public class OrderController {
    //
    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepository)
    {
        this.orderRepo = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {

        if(errors.hasErrors()) {
            return "orderForm";
        }

        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }


}
