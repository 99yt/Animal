package cn.blb.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.blb.boot.mapper")
public class UserApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class,args);
    }
}
