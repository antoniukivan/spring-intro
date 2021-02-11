package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    private static final AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(AppConfig.class);
    private static final UserService userService = context.getBean(UserService.class);

    public static void main(String[] args) {
        User alex = new User();
        alex.setName("Alex");
        userService.add(alex);

        User bob = new User();
        bob.setName("Bob");
        userService.add(bob);

        userService.listUsers().forEach(System.out::println);
    }
}
