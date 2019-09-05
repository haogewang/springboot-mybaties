package com.szhq.mybaties.dao;

import com.szhq.mybaties.models.User;
import com.szhq.mybaties.models.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserExendMapper {

    List<User> selectMyCustom(Map map);

}