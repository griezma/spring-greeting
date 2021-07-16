package griezma.springgreeting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SpringGreetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGreetingApplication.class, args);
    }

}

@ConfigurationProperties(prefix = "greet")
@Getter @Setter
class Greeting {
    private String message;
}

@RequestMapping("/greet")
@RestController
@RequiredArgsConstructor
class GreetingController {
    private final Greeting greeting;

    @GetMapping
    String getGreeting(@RequestParam(value = "name", defaultValue = "Mani") String name) {
        return String.format("<p>%s, %s</p>", greeting.getMessage(), name);
    }
}

