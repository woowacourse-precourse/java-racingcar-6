package racingcar.view;

import racingcar.constant.GameMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public void displayCarNamesInputMessage() {
        System.out.println(GameMessage.GAME_START_MESSAGE);
    }

    public void displayNumberOfTrialsQuestion() {
        System.out.println(GameMessage.ASK_TRIAL_NUMBERS_MESSAGE);
    }

    public void displayRoundResultMessage() {
        printBlankLine();
        System.out.println(GameMessage.ROUND_RESULT);
    }

    public void displayRaceStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + getFormattedPosition(car.getPosition()));
        }
        printBlankLine();
    }

    public void displayWinners(List<String> winnerNames) {
        System.out.print(GameMessage.WINNER_MESSAGE);
        System.out.println(String.join(", ", winnerNames));

    }

    public String getFormattedPosition(int position) {
        return "-".repeat(position);
    }

    public void printBlankLine() {
        System.out.println();
    }
}
