package racingcar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import racingcar.config.AutoAppConfig;
import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        RacingCarController racingCarController = context.getBean(
            "racingCarController",
            RacingCarController.class
        );

        racingCarController.run();

    }
}
