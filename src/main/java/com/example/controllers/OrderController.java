package com.example.controllers;

import com.example.dao.OrderRepository;
import com.example.entities.TacoOrder;
import com.example.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {

        System.out.println("==========" + order);
        if (errors.hasErrors()){
            System.out.println(errors.getAllErrors());
            return "orderForm";
        }
        log.info("Order submitted: {}", order);
        orderService.addOrder(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
