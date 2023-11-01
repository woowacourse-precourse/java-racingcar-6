package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Game {
    public void playAllRound() {
        List<Car> cars = setUpCars();
        int round = setUpRound();

        for (int i = 0; i < round; i++) {
            System.out.print(OutputView.NEW_LINE);
            playOneRound(cars);
        }

        OutputView.printWinners(findWinners(cars));
    }

    private List<Car> setUpCars() {
        List<Car> cars = new ArrayList<>();
        List<String> separatedCarNames = Converter.separateCarNames(InputView.inputCarNames());

        for (String carName : separatedCarNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private int setUpRound() {
        return Converter.convertRound(InputView.inputRound());
    }

    private void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            int number = NumberGenerator.generate();
            car.move(number);

            OutputView.printGameResult(car, car.getDistance());
        }
    }

    private List<Car> findWinners(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int findMaxDistance(List<Car> cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            if (car.getDistance() >= maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        return maxDistance;
    }
}
