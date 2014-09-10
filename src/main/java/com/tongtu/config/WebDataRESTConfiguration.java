package com.tongtu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/4/21 0021 16:31
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Configuration
public class WebDataRESTConfiguration extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        objectMapper.registerModule(new Hibernate4Module());
    }
}
