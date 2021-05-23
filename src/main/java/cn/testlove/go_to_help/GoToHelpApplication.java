package cn.testlove.go_to_help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 11:41
 * @Description: null
 */
@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
//@EnableConfigurationProperties
public class GoToHelpApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoToHelpApplication.class, args);
    }
}
