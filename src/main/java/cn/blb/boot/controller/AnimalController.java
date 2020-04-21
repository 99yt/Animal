package cn.blb.boot.controller;

import cn.blb.boot.beans.Animal;
import cn.blb.boot.mapper.AnimalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ironhide
 * @create 2020-04-20-18:02
 */
@RequestMapping("animal")
@Controller
public class AnimalController {

    @Autowired
    private AnimalMapper mapper;

    @GetMapping("select")
    public String toListPage() {
        return "animals";
    }

    @ResponseBody
    @GetMapping("list")
    public List<Animal> list() {
        List<Animal> animals = mapper.selectAll();
        return animals;
    }

    @ResponseBody
    @GetMapping("delete/{id}")
    public Integer deleteAnimal(@PathVariable("id") Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @PostMapping("saveOrUpdate")
    public String insert(Animal animal) {
        if (animal.getId() != null) {
            mapper.updateByPrimaryKeySelective(animal);
        } else {
            mapper.insertSelective(animal);
        }
        return "animals";
    }

    @GetMapping("toUpdatePage")
    public String toUpdatePage(Integer id, Model model) {
        model.addAttribute("animal", mapper.selectByPrimaryKey(id));
        return "updateAnimal";
    }

}
