package cn.testlove.go_to_help.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/5/22 13:20
 * @Description: null
 */
@Configuration
public class SwaggerConfig {
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2);
    }

}
