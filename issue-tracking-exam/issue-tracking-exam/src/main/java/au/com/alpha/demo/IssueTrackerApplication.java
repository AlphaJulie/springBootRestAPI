package au.com.alpha.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="au.com.domain.demo")
public class IssueTrackerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(IssueTrackerApplication.class, args);
    }
}
