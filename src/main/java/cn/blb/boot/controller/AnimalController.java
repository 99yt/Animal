package cn.blb.boot.controller;

import cn.blb.boot.beans.Animal;
import cn.blb.boot.mapper.AnimalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用的是tkmybatis提供的的方式进行crud
 */
@RequestMapping("animal")
@Controller
public class AnimalController {

    @Autowired
    private AnimalMapper mapper;

    /**
     * 进入主页面
     * @return
     */
    @GetMapping("select")
    public String toListPage() {
        return "animals";
    }

    /**
     * 查询
     * @return
     */
    @ResponseBody
    @GetMapping("list")
    public List<Animal> list() {
        List<Animal> animals = mapper.selectAll();
        return animals;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("delete/{id}")
    public Integer deleteAnimal(@PathVariable("id") Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 带id就执行修改，否则是增加
     * @param animal
     * @return
     */
    @PostMapping("saveOrUpdate")
    public String insert(Animal animal) {
        if (animal.getId() != null) {
            mapper.updateByPrimaryKeySelective(animal);
        } else {
            mapper.insertSelective(animal);
        }
        return "animals";
    }

    /**
     * 根据id查询 然后把数据带去修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("toUpdatePage")
    public String toUpdatePage(Integer id, Model model) {
        model.addAttribute("animal", mapper.selectByPrimaryKey(id));
        return "updateAnimal";
    }

}
