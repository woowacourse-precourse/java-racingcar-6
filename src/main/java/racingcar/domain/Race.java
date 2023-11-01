package racingcar.domain;

import racingcar.Car;
import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {
    NumberGenerator numberGenerator;

    public Race() {
        this.numberGenerator = new NumberGenerator();
    }

    public void moveCars(List<Car> cars) {
        List<Integer> randomNumbers = createNumber(cars.size());
        int count = 0;
        for (Car car : cars) {
            car.move(randomNumbers.get(count));
            count++;
        }
    }

    private List<Integer> createNumber(int carCount) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            int randomNumber = numberGenerator.createRandomNumber();
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}