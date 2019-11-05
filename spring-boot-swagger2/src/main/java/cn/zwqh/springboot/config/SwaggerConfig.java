package cn.zwqh.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(buildApiInf()) //将api的元信息设置为包含在json resourcelisting响应中
        //.host("127.0.0.1:8080") //设置ip和端口，或者域名
        .select()  //启动用于api选择的生成器
        //.apis(RequestHandlerSelectors.any())
        .apis(RequestHandlerSelectors.basePackage("cn.zwqh.springboot.controller"))//指定controller路径
        .paths(PathSelectors.any()).build();
    }

    private ApiInfo buildApiInf() {
    	
    	Contact contact=new Contact("朝雾轻寒","https://www.zwqh.top/","zwqh@clover1314.com");
        return new ApiInfoBuilder()
        .title("Swagger Demo Restful API Docs")//文档标题
        .description("Swagger 示例 Restful Api 文档")//文档描述
        .contact(contact)//联系人
        .version("1.0")//版本号
        //.license("")//更新此API的许可证信息
        //.licenseUrl("")//更新此API的许可证Url
        //.termsOfServiceUrl("")//更新服务条款URL
        .build();

    }
}
