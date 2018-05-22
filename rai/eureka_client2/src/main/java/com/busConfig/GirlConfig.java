package com.busConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Created with IntelliJ IDEA.
 * @author: XIAOPING JIANG
 * @Date: 2018/5/8
 * @Time: 15:09
 */
/*@Getter
@Setter*/
@Component
@ConfigurationProperties("girl")
@RefreshScope
public class GirlConfig {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
