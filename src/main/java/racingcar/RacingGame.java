package racingcar;

import java.util.List;

public class RacingGame {
    public void startGame() {
        List<Car> cars = InputView.inputCarsInfo();
        int round = InputView.inputRound();

        OutputView.printExecutionResultText();

        for (int count = 1; count <= round; count++) {
            proceedRound(cars);
            System.out.println();
        }
        printWinners(cars);
    }

    private void printWinners(List<Car> cars) {
        List<String> winners = getWinnersName(cars);
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    private void proceedRound(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            OutputView.printRoundResult(car.makeMoveResult());
        }
    }

    private List<String> getWinnersName(List<Car> cars) {
        int maxPosition = getWinnersPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getWinnersPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);
    }
}
