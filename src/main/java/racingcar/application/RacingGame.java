package racingcar.application;

import static racingcar.contants.RacingGameConstants.ATTEMPT_COUNT_MESSAGE;
import static racingcar.contants.RacingGameConstants.EXECUTION_RESULT_MESSAGE;
import static racingcar.contants.RacingGameConstants.INPUT_CAR_NAMES_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.util.GameResult;

public class RacingGame {
    private Cars cars;

    public void start() {
        String inputCarNames = getCarNamesFromUserInput();
        int count = getAttemptCountFromUserInput();
        cars = new Cars(inputCarNames);
        runRace(count, cars);
    }

    private String getCarNamesFromUserInput() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    private int getAttemptCountFromUserInput() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private void runRace(int count, Cars cars) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        for (int i = 0; i < count; i++) {
            cars.moveCars();
            GameResult.result(cars.getCars());
            System.out.println();
        }
        GameResult.finalResult(cars.getWinners(cars.getCars()));
    }
}
