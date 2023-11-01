package racingcar.v5;

import java.util.List;
import java.util.Map;

public class RacingGameProcessManagerV5 {
    public static void start() {
        CreateCarV5 createCar = new CreateCarV5();
        String inputCarNames = createCar.inputCarNames();
        List<String> validatedCarNames = createCar.validateCarNames(inputCarNames);
        Map<String, Integer> racingStateMap = createCar.racingStateMap(validatedCarNames);

        TryCountV5 tryCount = new TryCountV5();
        int validatedTryCount = tryCount.validateTryCount();

        ForwardV5 forward = new ForwardV5();
        RacingGameResultReportV5 report = new RacingGameResultReportV5();
        report.printResultTitle();
        for (int i = 0; i < validatedTryCount; i++) {
            for (String carName : validatedCarNames) {
                forward.updatePosition(racingStateMap, carName);
            }
            report.printCarPositionWithName(racingStateMap);
        }
        report.announceWinners(racingStateMap);
    }
}
