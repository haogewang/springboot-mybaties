package com.szhq.mybaties.controller;

import com.alibaba.fastjson.JSONObject;
import com.szhq.mybaties.models.User;
import com.szhq.mybaties.models.vo.PageBean;
import com.szhq.mybaties.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghao
 * @date 2019/9/4
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String getById(){
        User user = userService.getById("123");
        return user.getName();
    }

    @GetMapping("/pages")
    public String pages(@RequestParam("currentPage") Integer current, @RequestParam("pageSize") Integer pageSize){
        PageBean<User> pages = userService.pages(current, pageSize);
        return JSONObject.toJSONString(pages);
    }
}
