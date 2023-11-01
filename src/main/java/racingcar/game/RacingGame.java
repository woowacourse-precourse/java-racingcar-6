package racingcar.game;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class RacingGame {
    private static final String LAP_RESULT_DELIMITER = "\n";

    private final List<RacingCar> racingCars;
    private final int endLap;

    public RacingGame(List<RacingCar> racingCars, int endLap) {
        this.racingCars = racingCars;
        this.endLap = endLap;
    }

    public void run() {
        System.out.println("실행 결과");

        for (int i = 0; i < endLap; i++) {
            String lapResult = getLapResult();

            System.out.println(MessageFormat.format("{0}\n", lapResult));
        }
    }

    private String getLapResult() {
        return racingCars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(LAP_RESULT_DELIMITER));
    }
}
