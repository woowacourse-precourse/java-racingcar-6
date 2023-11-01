package racingcar.view;

import racingcar.Car;
import racingcar.messages.Message;

import java.util.List;

import static racingcar.GameManager.DISTANCE_CHAR;

public class OutputView {
    public void printNameInputPrompt() {
        System.out.println(Message.GAME_START_NAME);
    }

    public void printNumOfExecutionsInputPrompt() {
        System.out.println(Message.GAME_START_COUNT);
    }

    public void printGameResult() {
        System.out.println(Message.GAME_RESULT);
    }

    public void drawCarDistance(Car car) {
        System.out.printf("%s : %s\n", car.getName(), DISTANCE_CHAR.repeat(car.getDistance()));
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toList());
        System.out.printf("%s%s", Message.FINAL_WINNER, winnerNames);
    }
}
