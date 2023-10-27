package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Circuit {

    private final List<Car> cars;

    private Circuit(List<Car> cars) {
        this.cars = cars;
    }

    public static Circuit fromCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Circuit(cars);
    }

    public List<Car> moveCars(List<Integer> randomNumbers) {
        IntStream.range(0, getCircuitSize())
                .forEach(index -> getMove(randomNumbers, index));
        return cars;
    }

    private void getMove(List<Integer> randomNumbers, int index) {
        Integer randomNumber = randomNumbers.get(index);
        Car car = this.cars.get(index);
        car.move(randomNumber);
    }

    public int getCircuitSize() {
        return this.cars.size();
    }

}
