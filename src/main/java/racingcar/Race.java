package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int count;

    public Race(List<Car> cars, int count) {
        this.cars = cars;
        this.count = count;
    }
}
