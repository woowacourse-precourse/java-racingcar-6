package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Garage {

    private final List<Car> cars;

    private Garage(List<Car> cars) {
        this.cars = cars;
    }

    public static Garage fromCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Garage(cars);
    }

    public void moveCars(List<Integer> randomNumbers) {
        IntStream.range(0, getGarageSize())
                .forEach(index -> getMove(randomNumbers, index));
    }

    private void getMove(List<Integer> randomNumbers, int index) {
        Integer randomNumber = randomNumbers.get(index);
        Car car = this.cars.get(index);
        car.move(randomNumber);
    }

    public int getGarageSize() {
        return this.cars.size();
    }

}
