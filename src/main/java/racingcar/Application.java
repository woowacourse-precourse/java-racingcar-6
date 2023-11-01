package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) {
            InputView inputView = new InputView();
            List<Car> cars = inputView.inputCarNames();

            int tryCount = inputView.inputTryCount();

            for (int i = 0; i < tryCount; i++) {
                for (Car car : cars) {
                    car.move();
                    OutputView.printCurrentPosition(car);
                }
                OutputView.printNewLine();
            }

            List<Car> winners = getWinners(cars);
            OutputView.printWinners(winners);
        }

        private static List<Car> getWinners(List<Car> cars) {
            int maxPosition = 0;
            for (Car car : cars) {
                maxPosition = Math.max(maxPosition, car.getPosition());
            }

            List<Car> winners = new ArrayList<>();
            for (Car car : cars) {
                if (car.getPosition() == maxPosition) {
                    winners.add(car);
                }
            }
            return winners;
        }
    }