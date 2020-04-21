package cn.blb.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Router {

    @GetMapping("toListPage")
    public String toListPage() {
        return "animals";
    }

    @GetMapping("toInsertAnimal")
    public String toInsertAnimal() {
        return "insertAnimal";
    }

}
