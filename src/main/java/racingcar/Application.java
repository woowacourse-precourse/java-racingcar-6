package racingcar;

import racingcar.config.RacingCarFramework;
import racingcar.domain.race.RaceResult;
import racingcar.usecase.RacingCarUseCase;

public class Application {
    public static void main(String[] args) {
        RacingCarFramework instance = RacingCarFramework.getInstance();

        RacingCarUseCase racingCarUseCase = instance.getBean(RacingCarUseCase.class);

        RaceResult raceResult = racingCarUseCase.play();
        racingCarUseCase.printWinnerMessage(raceResult);
    }
}
