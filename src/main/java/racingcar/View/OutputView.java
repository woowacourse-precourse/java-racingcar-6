package racingcar.View;

import static racingcar.Message.OutputMessage.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.Car;

public class OutputView {

    public void printResult(List<String> results) {
        printResultMessage();
        printRaceResult(results);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRaceResult(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }

    public void printWinner(List<Car> winners) {
        if (winners.size() > 1) {
            printWinners(winners);
        } else {
            printSoleWinner(winners);
        }
    }

    public void printSoleWinner(List<Car> car) {
        System.out.println(WINNER_MESSAGE + CAR_DELIMITER + car.get(0).getName());
    }

    public void printWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.add(car.getName());
        }
        String resultWinners = String.join(WINNER_DELIMITER, winners);
        System.out.println(WINNER_MESSAGE + CAR_DELIMITER + resultWinners);
    }
}