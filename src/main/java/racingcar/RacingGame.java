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
        printWinner(cars);
    }

    private void printWinner(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        result.append("최종 우승자 : ");
        result.append(String.join(", ", getWinnerNames(cars)));
        System.out.println(result);
    }

    private void proceedRound(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            OutputView.printRoundResult(car.makeMoveResult());
        }
    }

    private List<String> getWinnerNames(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);
    }
}
