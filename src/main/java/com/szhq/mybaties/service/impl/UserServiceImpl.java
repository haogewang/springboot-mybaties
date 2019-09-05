package com.szhq.mybaties.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.szhq.mybaties.dao.UserExendMapper;
import com.szhq.mybaties.dao.UserMapper;
import com.szhq.mybaties.models.User;
import com.szhq.mybaties.models.UserExample;
import com.szhq.mybaties.models.vo.PageBean;
import com.szhq.mybaties.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghao
 * @date 2019/9/4
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserExendMapper userExendMapper;

    @Override
    public User getById(String id) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "1");
        map.put("id", "1");
        System.out.println(JSONObject.toJSONString(userExendMapper.selectMyCustom(map)));
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean<User> pages(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        UserExample example = new UserExample();
        example.createCriteria().andNameLike("%1%");
        List<User> list = userMapper.selectByExample(example);
        long total = userMapper.countByExample(example);
        PageBean<User> pages = new PageBean<User>(currentPage, pageSize, total);
        pages.setItems(list);
        return pages;
    }
}
