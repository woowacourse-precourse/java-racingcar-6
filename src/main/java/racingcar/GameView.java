package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameView {
    Validator validator = new Validator();

    public List<String> getCarNames() {
        System.out.println(Message.ASK_CAR_NAMES.getMessage());
        String userInput = readLine();
        List<String> carNames = Arrays.asList(userInput.split(","));
        for (String name : carNames) {
            validator.validateNameLength(name);
        }
        return carNames;
    }

    public int getRoundCount() {
        System.out.println(Message.ASK_ROUND_COUNT.getMessage());
        String userInput = readLine();

        return Integer.parseInt(userInput);
    }

    public void printExecutionTitle() {
    }

    public void printExecutionResult(List<Car> cars) {
    }

    public void printWinners(List<String> winners) {
    }
}
