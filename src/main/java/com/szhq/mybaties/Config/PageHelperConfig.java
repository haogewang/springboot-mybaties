package com.szhq.mybaties.Config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author wanghao
 * @date 2019/9/4
 */
@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        // 分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页，
        // pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询
        properties.setProperty("reasonable", "false");
        //配置mysql数据库的方言
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

}
