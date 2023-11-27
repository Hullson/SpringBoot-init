package com.demo.controller.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connect")
public class ProgramController {

    @GetMapping("program")
    public String Program() {
        return "connect success";
    }
}
