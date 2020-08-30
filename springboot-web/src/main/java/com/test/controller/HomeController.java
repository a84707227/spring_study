package com.test.controller;

import com.test.pojo.Home;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        System.out.println("hello world");
        System.out.println("welcome从 ");
        System.out.println("test");
        return "home";
    }

    @RequestMapping(value = "/homeList",method = RequestMethod.GET)
    @ResponseBody
    public String findHomeListByUrl(@RequestParam("pageSize") int pageSize,@RequestParam("pageNum") int pageNum){
        System.out.println("每页大小：" + pageSize + ";当前页：" + pageNum);
        return "findHomeListByUrl";
    }

    @RequestMapping(value = "/homeList2",method = RequestMethod.GET)
    @ResponseBody
    public String findHomeListByUrl2(@RequestParam(value = "pageSize",defaultValue = "15") int pageSize,@RequestParam("pageNum") int pageNum){
        System.out.println("每页大小：" + pageSize + ";当前页：" + pageNum);
        return "findHomeListByUrl";
    }

    @RequestMapping(value = "/getHome/{homeId}/{homeName}",method = RequestMethod.GET)
    @ResponseBody
    public String getHome(@PathVariable("homeId") String homeId,@PathVariable String homeName){
        System.out.println("Home的ID是：" + homeId + "Home的名称：" + homeName);
        return "getHome";
    }

    @RequestMapping(value = "saveHome", method = RequestMethod.POST)
    @ResponseBody
    public Object saveHome(@Valid Home home, Errors errors){
        if (errors.hasErrors()){
            System.out.println("错误内容："+errors.getFieldErrors());
            return errors;
        }
        System.out.println(home);
        return "home";
    }


}
