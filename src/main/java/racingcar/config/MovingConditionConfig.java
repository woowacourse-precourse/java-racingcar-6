package racingcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import racingcar.model.MoreFastRacingCarMovingCondition;
import racingcar.model.MovingCondition;
import racingcar.model.RacingCarMovingCondition;

@Configuration
public class MovingConditionConfig {

    @Bean
    public MovingCondition racingCarMovingCondition() {
        return new RacingCarMovingCondition();
    }

    @Bean
    public MovingCondition moreFastRacingCarMovingCondition() {
        return new MoreFastRacingCarMovingCondition();
    }

}
