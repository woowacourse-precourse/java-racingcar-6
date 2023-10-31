package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private static final int START_NUM = 0;
    private static final int END_NUM = 9;

    private RacingCars racingCars;
    private MoveNumGenerator moveNumGenerator;

    public RacingCarGame(String[] carNames) {
        racingCars = new RacingCars(carNames);
        this.moveNumGenerator = new MoveNumGenerator(START_NUM, END_NUM);
    }

    public List<Result> run() {
        return racingCars.moveCars(moveNumGenerator);
    }

    public List<String> reportWinners() {
        List<String> winners = new ArrayList<>();
        for (Result result : racingCars.findWinners()) {
            winners.add(result.getName());
        }

        return winners;
    }

}
