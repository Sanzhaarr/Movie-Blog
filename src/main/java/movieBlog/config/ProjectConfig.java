package movieBlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "movieBlog")
public class ProjectConfig {

//    @Bean
//    Movie movie(){
//        var movie = new Movie();
//        return movie;
//    }

}
