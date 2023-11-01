package racingcar.domain;

import static racingcar.validation.CheckingInput.checkInputCount;
import static racingcar.validation.CheckingInput.checkInputNames;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.SystemMessage;

public class Game {
    private final Racing racing;

    public Game() {
        racing = new Racing();
    }

    private void executeSteps() {
        for (int i = 0; i < racing.getAttemptCount(); i++) {
            racing.runCarsOnce();
            printCarsResult();
            System.out.print("\n");
        }
    }

    private void printCarsResult() {
        for (Car car : racing.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getStep()));
        }
    }

    public void execute() {
        System.out.println(SystemMessage.PLEASE_INPUT_CAR_NAME);

        String[] carNames = (Console.readLine()).split(",");
        checkInputNames(carNames);
        racing.setCars(carNames);

        System.out.println(SystemMessage.PLEASE_INPUT_ATTEMPT_NUMBER);

        String count = Console.readLine();
        checkInputCount((count));
        racing.setAttemptCount(count);

        System.out.println("\n" + SystemMessage.RACING_RESULT);
        executeSteps();

        System.out.println(SystemMessage.RACING_WINNER + " : " + racing.getWinners());
    }
}
