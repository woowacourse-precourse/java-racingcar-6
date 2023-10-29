package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.NumberConstant.MAX_RANDOM_NUMBER;
import static racingcar.constant.NumberConstant.MIN_RANDOM_NUMBER;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void move() {
        cars.stream()
                .filter(car -> car.canGo(makeRandomNumber()))
                .forEach(Car::go);
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int winnerPosition = getWinnerPosition();

        for (Car car : cars) {
            if (car.isWinner(winnerPosition)) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private int getWinnerPosition() {
        int winnerPosition = 0;
        for (Car car : cars) {
            if (winnerPosition < car.getPosition()) {
                winnerPosition = car.getPosition();
            }
        }
        return winnerPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
