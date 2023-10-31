package racingcar.model;

import racingcar.utils.Separator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        Stream<String> streamString = Stream.of(Separator.separateStringByRegex(carNames));
        streamString.forEach(s -> this.cars.add(new Car(s, 0)));
    }

    public Cars(List<Car> cars) {
        for(Car car : cars) {
            this.cars.add(car);
        }
    }

    public void compete() {
        for (Car car : cars) car.move();
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
