package com.Rustam.controller;

import com.Rustam.helper.db.SecondTask;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Владислав on 28.12.2014.
 */
@Controller
@RequestMapping(value = "task2")
//вот так выглядит безыдейность и проявляется она в название методов
public class Task2Controller {

    @RequestMapping(value = "1")
    public String first(ModelMap model) {
        model = new SecondTask().firstRequestHandler(model);
        return "task2";
    }

    @RequestMapping(value = "2")
    public String second(ModelMap model) {
        model = new SecondTask().secondRequestHandler(model);
        return "task2";
    }

    @RequestMapping(value = "3")
    public String third(ModelMap model) {
        model = new SecondTask().firstRequestHandler(model);
        return "task2";
    }

    @RequestMapping(value = "4")
    public String fourth(ModelMap model) {
        model = new SecondTask().firstRequestHandler(model);
        return "task2";
    }

}
