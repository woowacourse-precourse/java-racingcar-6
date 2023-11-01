package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void startGame() {
        List<Car> cars = InputView.inputCarsInfo();
        int round = InputView.inputRound();

        System.out.println("실행 결과");

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
            System.out.println(car.makeMoveResult());
        }
    }

    private List<String> getWinnerNames(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);

        for (Car car : cars) {
            int position = car.getPosition();

            if (position == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            int position = car.getPosition();

            if (position > maxPosition) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }
}
