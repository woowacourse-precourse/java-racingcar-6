package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public int size() {
        return cars.size();
    }

    public Cars(String names) {
        this.cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void race() {
        cars.forEach(car -> car.goForwardByNumber(Randoms.pickNumberInRange(1, 9)));
    }

    public String getPositions() {
        StringBuilder positions = new StringBuilder();
        cars.forEach(car -> positions.append(car.toString()).append("\n"));

        return positions.toString();
    }

}
