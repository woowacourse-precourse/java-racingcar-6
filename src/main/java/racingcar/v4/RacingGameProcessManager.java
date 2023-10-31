package racingcar.v4;

import java.util.List;
import java.util.Map;

public class RacingGameProcessManager {
    public static void start() {
        try {
            CreateCar createCar = new CreateCar();
            String inputCarNames = createCar.inputCarNames();
            List<String> validatedCarNames = createCar.validateCarNames(inputCarNames);
            Map<String, Integer> racingStateMap = createCar.racingStateMap(validatedCarNames);

            TryCount tryCount = new TryCount();
            int validatedTryCount = tryCount.validateTryCount();

            Forward forward = new Forward();
            for (int i = 0; i < validatedTryCount; i++) {
                for (String carName : validatedCarNames) {
                    forward.updatePosition(racingStateMap, carName);
                }
                RacingGameResultReport report = new RacingGameResultReport();
                report.printCarPositionWithName(racingStateMap);
            }

            RacingGameResultReport report = new RacingGameResultReport();
            report.announceWinners(racingStateMap);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
