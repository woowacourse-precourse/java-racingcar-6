package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class GameService {

    private static final int MIN_MOVE_NUMBER = 0;
    private static final int MAX_MOVE_NUMBER = 9;


    public void moveCars(List<Car> cars) {

        cars.forEach(car -> car.tryMove(makeRandomNumberForMove()));
    }

    public List<String> findWinner(List<Car> cars) {

        int maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition().length() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int makeRandomNumberForMove() {

        return Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER);
    }

    private int findMaxPosition(List<Car> cars) {

        return cars.stream()
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0);
    }
}
