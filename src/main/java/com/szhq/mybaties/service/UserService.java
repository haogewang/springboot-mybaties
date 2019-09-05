package com.szhq.mybaties.service;

import com.szhq.mybaties.models.User;
import com.szhq.mybaties.models.vo.PageBean;

import java.util.List;

/**
 * @author wanghao
 * @date 2019/9/4
 */
public interface UserService {

    public User getById(String id);

    public PageBean<User> pages(int currentPage, int pageSize);
}
