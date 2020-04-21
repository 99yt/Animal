package cn.blb.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TsertController {

    @GetMapping("str.do")
    @ResponseBody
    public String test(){
        return "测试路径";
    }
}
