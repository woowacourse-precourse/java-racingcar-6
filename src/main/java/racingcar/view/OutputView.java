package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.GameMessage;
import racingcar.domain.Car;
import racingcar.domain.CarDto;

public class OutputView {
    public void requestCarNames() {
        printLn(GameMessage.REQUEST_CAR_NAMES.getMessage());
    }

    public void requestRounds() {
        printLn(GameMessage.REQUEST_ROUNDS.getMessage());
    }

    public void printExecutionResult() {
        newLine();
        printLn(GameMessage.EXECUTION_RESULT.getMessage());
    }

    public void printCarStatus(List<CarDto> carStatus) {
        for (CarDto status : carStatus) {
            printLn(status.getStatus());
        }
        newLine();
    }

    public void announceWinner(List<Car> winners) {
        print(GameMessage.FINAL_WINNER.getMessage());
        printLn(winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }

    private void printLn(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void newLine() {
        System.out.println();
    }
}