package com.example.demo.conf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class Swagger2Config implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-api文档")
                .description("swagger接入教程")
                //服务条款网址
                .termsOfServiceUrl("https://blog.csdn.net/")
                .version("1.0")
                .contact(new Contact("zhang", "https://blog.csdn.net/", "2196723810@qq.com"))
                .build();
    }
    
    /*@Override    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {        
    	registry.addResourceHandler("swagger-ui.html")                
    	.addResourceLocations("classpath:/META-INF/resources/");         
    	registry.addResourceHandler("/webjars/**")                
    	.addResourceLocations("classpath:/META-INF/resources/webjars/");    
    }*/

}


/*
  Docket类的方法：
  Docket groupName(String var):设置栏目名

  Docket apiInfo(ApiInfo apiInfo):设置文档信息

  Docket pathMapping(String path):设置api根路径

  Docket protocols(Set<String> protocols):设置协议，Sets为com.goolge.common下的类，Sets.newHashSet("https","http")相当于new HashSet(){{add("https");add("http");}};

  ApiSelectorBuilder select():初始化并返回一个API选择构造器



  ApiSelectorBuilder类的方法：

  ApiSelectorBuilder apis(Predicate<RequestHandler> selector):添加选择条件并返回添加后的ApiSelectorBuilder对象

  ApiSelectorBuilder paths(Predicate<String> selector):设置路径筛选，该方法中含一句pathSelector = and(pathSelector, selector);表明条件为相与



  RequestHandlerSelectors类的方法：

  Predicate<RequestHandler> any()：返回包含所有满足条件的请求处理器的断言，该断言总为true

  Predicate<RequestHandler> none()：返回不满足条件的请求处理器的断言,该断言总为false

  Predicate<RequestHandler> basePackage(final String basePackage)：返回一个断言(Predicate)，该断言包含所有匹配basePackage下所有类的请求路径的请求处理器



  PathSelectors类的方法：

  Predicate<String> any():满足条件的路径，该断言总为true

  Predicate<String> none():不满足条件的路径,该断言总为false

  Predicate<String> regex(final String pathRegex):符合正则的路径



设置swagger-ui.html默认路径，servlet的配置文件添加:

  <mvc:annotation-driven></mvc:annotation-driven>
  <mvc:resources mapping="/webjars/**" location="classpath:/META-INF/resources/webjars"/>

  swagger-ui.html位于springfox-swagger-ui jar包中的META-INF/resources/目录下，项目编译后swagger-ui.html将添加到classpath的/META-INF/resources/下，所以添加mapping="/webjars/**" 可通过localhost:端口号/项目名/swagger-ui.html打开SwaggerUI

常用注解:

  Swagger所有注解并非必须，若不加就只显示类目/方法名/参数名没有注释而已，但若注解中含@ApiParam不对应@RequestParam将无效果

  @Api:注解controller，value为@RequestMapping路径

  @ApiOperation:注解方法，value为简要描述,notes为全面描述,hidden=true Swagger将不显示该方法，默认为false

  @ApiParam:注解参数,hidden=true Swagger参数列表将不显示该参数,name对应参数名，value为注释，defaultValue设置默认值,allowableValues设置范围值,required设置参数是否必须，默认为false

  @ApiModel:注解Model

  @ApiModelProperty:注解Model下的属性，当前端传过来的是一个对象时swagger中该对象的属性注解就是ApiModelProperty中的value

  @ApiIgnore:注解类、参数、方法，注解后将不在Swagger UI中显示


*/

