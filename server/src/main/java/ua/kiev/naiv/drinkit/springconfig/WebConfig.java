package ua.kiev.naiv.drinkit.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author pkolmykov
 */
@Configuration
@ComponentScan({
        "ua.kiev.naiv.drinkit.cocktail.controller",
        "ua.kiev.naiv.drinkit.cocktail.common"
})
@EnableWebMvc
@EnableAspectJAutoProxy
public class WebConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

}
