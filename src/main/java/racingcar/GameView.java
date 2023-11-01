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
        System.out.println(Message.EXECUTION_RESULT_TITLE.getMessage());
    }

    public void printExecutionResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getStep(); i++) { System.out.print("-");}
            System.out.println("");
        }
        System.out.println("");
    }

    public void printWinners(List<String> winners) {
        System.out.print(Message.WINNER.getMessage());
        System.out.print(winners.get(0));
        int winnerCount = winners.size();
        if (winnerCount > 1) {
            for (int i = 1; i < winnerCount; i++) {
                System.out.print("," + winners.get(i));
            }
        }
    }
}
