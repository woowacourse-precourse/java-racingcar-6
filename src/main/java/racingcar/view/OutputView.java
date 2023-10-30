package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;
import racingcar.message.ProcessMessage;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printInputCarNameMessage() {
        System.out.println(ProcessMessage.INPUT_NAME);
    }

    public void printInputAttemptCountMessage() {
        System.out.println(ProcessMessage.INPUT_ATTEMPT_COUNT);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printProcessResultTitle() {
        printNewLine();
        System.out.println(ProcessMessage.PROCESS_RESULT);
    }

    public void printWinnerName(Winners winners) {
        printWinnerTitle();
        System.out.println(winners.toString());
                winners.stream()
                        .map(Car::getName)
                        .collect(Collectors.joining(", "))
        );
    }

    private void printWinnerTitle() {
        System.out.print(ProcessMessage.WINNER_TITLE);
    }

    public void printMoveRecords(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
        printNewLine();
    }
}
