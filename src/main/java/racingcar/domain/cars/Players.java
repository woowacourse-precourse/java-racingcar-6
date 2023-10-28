package racingcar.domain.cars;

import java.util.List;
import racingcar.domain.car.Car;

public class Players {

    private final List<Car> cars;

    public Players(List<String> names) {
        List<Car> cars = names.stream()
            .map(Car::new)
            .toList();
        this.cars = cars;
    }

    public List<Car> cars() {
        return cars;
    }

    public void moveAll() {
        cars.forEach((car) -> car.move());
    }

    @Override
    public String toString() {
        List<String> carMessages = cars.stream()
            .map(Car::toString)
            .toList();
        return String.join("\n", carMessages);
    }
}
