package com.szhq.mybaties.util;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 解决Mybatis generator mapper文件重新生成不会覆盖原文件
 * @author wanghao
 * @date 2019/8/27
 */
@Slf4j
public class OverIsMergeablePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
           log.error("e", e);
        }
        return true;
    }
}
