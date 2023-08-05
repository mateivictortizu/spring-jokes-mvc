package com.springframework.jokesapp.controllers;

import com.springframework.jokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {
    private final JokeService jokeService;

    //un singur constructor -> face automat DI, fara @Autowired
    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping("/")
    public String showJoke(Model model)
    {
        model.addAttribute("joke", jokeService.getJoke());
        return "index";
    }
}
