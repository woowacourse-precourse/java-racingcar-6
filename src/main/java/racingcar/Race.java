package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void start() {
        ResultView.printLineBreak();
        ResultView.printResultNotification();
        for (int i = 0; i < rounds; i++) {
            moveCarsRandomly();
        }
    }

    public void moveCarsRandomly() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            moveCarRandomly(car, randomNumber);
            ResultView.printCarPosition(car);
        }
        ResultView.printLineBreak();
    }

    public void moveCarRandomly(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveForward();
        }
    }

    public static String findWinners(List<Car> carList) {
        int maxPositionLength = calculateMaxPositionLength(carList);
        List<String> winners = getWinningCarNames(carList, maxPositionLength);
        return String.join(", ", winners);
    }

    public static int calculateMaxPositionLength(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPositionLength)
                .max()
                .orElse(0);
    }

    public static List<String> getWinningCarNames(List<Car> carList, int maxPositionLength) {
        return carList.stream()
                .filter(car -> car.isWinner(maxPositionLength))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
