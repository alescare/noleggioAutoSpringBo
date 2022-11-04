package com.example.springboot.NoleggioAutoSpringBoot.controller;

import com.example.springboot.NoleggioAutoSpringBoot.service.AutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auto")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }
}
