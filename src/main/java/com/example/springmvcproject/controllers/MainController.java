package com.example.springmvcproject.controllers;

import com.example.springmvcproject.dao.QuestionsDAO;
import com.example.springmvcproject.dao.UserDAO;
import com.example.springmvcproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/question")
public class MainController {

    private final UserDAO personDAO;
    @Autowired
    private final QuestionsDAO questionsDAO;

    @Autowired
    public MainController(UserDAO personDAO, QuestionsDAO questionsDAO) {
        this.personDAO = personDAO;
        this.questionsDAO = questionsDAO;
    }

    @GetMapping()
    public String index(@ModelAttribute("person") User user, Model model) {
        personDAO.checkUser(user);
        return "question/start";
    }

    @GetMapping("/start")
    public String showQuestion(Model model) {
        model.addAttribute("question", questionsDAO.getQuestions());
        return "show";
    }

    @GetMapping("/showResult")
    public String newPerson(Model model) {
        model.addAttribute("question", personDAO.showResult());
        return "result";
    }




}