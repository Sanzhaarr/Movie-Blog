package movieBlog.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    CommandLineRunner initialDatabase(MovieRepository movieRepo){
        return args -> {
            log.info("asfjslfj");

        };
    }



}
