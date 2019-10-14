package com.alipay.demo.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：WenYuQi
 * @date ： 2019/10/11 9:51
 */
@RestController
@AllArgsConstructor
@Api(value = "视图渲染")
public class ModelAndViewController {

    @RequestMapping("/pay")
    public ModelAndView url(){
        return  new ModelAndView("pay");
    }

    @RequestMapping("/test")
    public ModelAndView testurl(){
        return  new ModelAndView("test");
    }

}
