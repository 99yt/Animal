package cn.blb.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义拦截器配置类
 *
 */
@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    /**
     * 通过@Bean注解，将我们定义的拦截器注册到Spring容器
     * @return
     */
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();

    }

    /**
     * 重写，添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //通过registry来注册拦截器，通过addPathPatterns添加拦截路径
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/");
    }





}
