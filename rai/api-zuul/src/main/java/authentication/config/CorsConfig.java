package authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/5/29 0029.
 * zuul 跨域
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter CorsConfig(){

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); //是否支持cookie跨域
        config.setAllowedOrigins(Arrays.asList("/**"));//原始域 // http:www.a.com
        config.setAllowedHeaders(Arrays.asList("/**"));//允许的请求头
        config.setAllowedMethods(Arrays.asList("/**"));//允许的请求方法 GET POST
        config.setMaxAge(300l); //相同请求 不检查缓存


        source.registerCorsConfiguration("/**",config); //那个域名下的

        return  new CorsFilter(source);
    }

}
