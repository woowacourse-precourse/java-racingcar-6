package racingcar.service;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.NumberGenerator;

public class Race {
    private final NumberGenerator numberGenerator;

    public Race(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void start(List<Car> races, int count){
        for (int i = 0; i<count; i++) {

        }
    }
}
