package com.unipoint.webapp.springboot.web;

import com.unipoint.webapp.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/hello")
    public String hello()
    {
        System.out.println("Hello Test");
        return "Hello Test";
    }

    @GetMapping("/KSJ")
    public String KSJ()
    {
        System.out.println("KSJ Test");
        return "KSJ Test";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name, amount);
    }
}
