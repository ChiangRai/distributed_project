package com.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/6/1 0001.
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {


    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getHystrix")
    public String getEureka_client() {
        //第一种
        RestTemplate restTemplate = new RestTemplate();
        //第一个参数 是调用的地址.第二个是返回的类型.
        String forObject = restTemplate.getForObject("http://localhost:8086/msg", String.class);
        return forObject;
    }

    public String fallback() {
        return "太拥挤了";
    }


    public String defaultFallback() {
        return "d 这里是默认提示太拥挤了";
    }

    @HystrixCommand    //这里不填写就是使用默认的fallback
    @GetMapping("/defaultFallback")
    public String defaultFall() {   //对方延时5秒
        //第一种
        RestTemplate restTemplate = new RestTemplate();
        //第一个参数 是调用的地址.第二个是返回的类型.
        String forObject = restTemplate.getForObject("http://localhost:8086/Hystrix", String.class);
        return forObject;
    }


    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getHystrix2")
    public String getHystrix() {   //对方延时5秒
        //第一种
        RestTemplate restTemplate = new RestTemplate();
        //第一个参数 是调用的地址.第二个是返回的类型.
        String forObject = restTemplate.getForObject("http://localhost:8086/Hystrix", String.class);
        return forObject;
    }


    //超时配置
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")//超时时间
            }
    )//超时时间 延时的处理方法
    @GetMapping("/getHystrixDelayed")
    public String getHystrixDelayed() {   //对方延时5秒
        //第一种
        RestTemplate restTemplate = new RestTemplate();
        //第一个参数 是调用的地址.第二个是返回的类型.
        String forObject = restTemplate.getForObject("http://localhost:8086/Hystrix", String.class);
        return forObject;
    }


    //熔断
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //短路开关  该配置控制是否开启熔断器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数 10  该配置设置窗口期内触发熔断的最小请求数，例如该值设置成20，当只有19个请求时，即使这19个请求都失败，也不会触发熔断。
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//休眠时间.半开状态
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//百分比  如果10次 有6次请求错误. 断路器进入 在进入则是触发熔断机制
            }
    )//超时时间 延时的处理方法
    @GetMapping("/getHystrixFusing")
    public String getHystrixFusing(@RequestParam("number") Integer number) {   //对方延时5秒
        if (number % 2 == 0) {
            //第一种
            RestTemplate restTemplate = new RestTemplate();
            //第一个参数 是调用的地址.第二个是返回的类型.
            String forObject = restTemplate.getForObject("http://localhost:8086/Hystrix", String.class);
            return forObject;
        }
        return "成功";

    }


    //使用配置文件 方式配置
    // @HystrixCommand(commandKey = )//默认是方法名
    @HystrixCommand
    @GetMapping("/getHystrixDelayedConfigurationFile")
    public String getHystrixDelayedConfigurationFile() {   //对方延时5秒
        //第一种
        RestTemplate restTemplate = new RestTemplate();
        //第一个参数 是调用的地址.第二个是返回的类型.
        String forObject = restTemplate.getForObject("http://localhost:8086/Hystrix", String.class);
        return forObject;
    }



}
