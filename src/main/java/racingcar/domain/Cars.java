package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        carList = carNames.stream().map(Car::new).toList();
    }

    public void run(NumberGenerator numberGenerator) {
        for (Car car : carList) {
            int randomNumber = numberGenerator.generator();
            car.run(randomNumber);
        }
    }

    public List<Car> getCars() {
        return carList;
    }
}
