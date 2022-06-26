package xyz.filipkober.springdemoapp.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner runner(UserRepository repository){
        return args -> {
            User filip = new User("Filip","koberfilip2@gmail.com", LocalDate.of(2006, Month.JANUARY, 31));
            User jakub = new User("Jakub","jsrokowski05@gmail.com", LocalDate.of(2005, Month.OCTOBER, 25));
            repository.saveAll(List.of(filip, jakub));
        };
    }
}
