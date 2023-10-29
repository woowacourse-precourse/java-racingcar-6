package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    public List<String> findWinner(List<Car> cars) {

        int maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition().length() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int makeRandomNumberForMove() {

        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isMove(int randomNumber) {

        return randomNumber >= 4;
    }

    private int findMaxPosition(List<Car> cars) {

        return cars.stream()
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0);
    }
}
