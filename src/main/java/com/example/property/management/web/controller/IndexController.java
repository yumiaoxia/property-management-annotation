package com.example.property.management.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/index")
@Api(tags = "测试")
public class IndexController {

    @ApiOperation("测试接口")
    @GetMapping("/hello")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/hello");
        return mv;
    }

}
