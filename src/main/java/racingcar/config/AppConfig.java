package racingcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import racingcar.controller.RacingCarController;
import racingcar.io.input.InputManager;
import racingcar.io.input.InputMapper;
import racingcar.io.input.InputView;
import racingcar.io.output.OutputView;
import racingcar.model.MovingCondition;
import racingcar.model.RacingCarMovingCondition;
import racingcar.service.CarService;
import racingcar.service.RacingCarService;


@Configuration
public class AppConfig {

    @Bean("racingCarController")
    public RacingCarController racingCarController() {
        return new RacingCarController(inputManager(), outputView(), racingCarService());
    }

    @Bean
    public CarService racingCarService() {
        return new RacingCarService(movingCondition());
    }

    @Bean
    public MovingCondition movingCondition() {
        return new RacingCarMovingCondition();
    }

    @Bean
    public OutputView outputView() {
        return new OutputView();
    }

    @Bean
    public InputManager inputManager() {
        return new InputManager(inputView(), inputMapper());
    }

    @Bean
    public InputMapper inputMapper() {
        return new InputMapper();
    }

    @Bean
    public InputView inputView() {
        return new InputView();
    }
}
