package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.List;

public class GameService {

    private static final int MIN_MOVE_NUMBER = 0;
    private static final int MAX_MOVE_NUMBER = 9;


    public void moveCars(List<Car> cars) {

        cars.forEach(car -> car.tryMove(makeRandomNumberForMove()));
    }

    public List<Name> findWinner(List<Car> cars) {

        Position maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .map(Car::getName)
                .toList();
    }

    private int makeRandomNumberForMove() {

        return Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER);
    }

    private Position findMaxPosition(List<Car> cars) {

        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElse(new Position(0));
    }
}
