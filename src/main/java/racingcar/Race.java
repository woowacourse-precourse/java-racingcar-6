package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start() {
        ResultView.printLineBreak();
        ResultView.printResultNotification();
        for (int i = 0; i < rounds; i++) {
            moveCarsRandomly();
        }
    }

    private void moveCarsRandomly() {
        for (Car car : cars) {
            moveCarRandomly(car);
            ResultView.printCarPosition(car);
        }
        ResultView.printLineBreak();
    }

    private void moveCarRandomly(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.moveForward();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public static String findWinners(List<Car> carList) {
        int maxPositionLength = calculateMaxPositionLength(carList);
        List<String> winners = getWinningCarNames(carList, maxPositionLength);
        return String.join(", ", winners);
    }

    private static int calculateMaxPositionLength(List<Car> carList) {
        int maxPositionLength = 0;
        for (Car car : carList) {
            if (car.getPositionLength() > maxPositionLength) {
                maxPositionLength = car.getPositionLength();
            }
        }
        return maxPositionLength;
    }

    private static List<String> getWinningCarNames(List<Car> carList, int maxPositionLength) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.isWinner(maxPositionLength)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
