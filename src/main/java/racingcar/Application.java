package racingcar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import racingcar.config.AppConfig;
import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            AppConfig.class);

        RacingCarController racingCarController = applicationContext.getBean(
            "racingCarController",
            RacingCarController.class
        );

        racingCarController.run();

    }
}
