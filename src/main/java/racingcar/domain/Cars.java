package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private static final String CAR_NAME_SEPARATOR = ",";
    private final List<Car> cars = new ArrayList<>();

    public Cars(String inputValue) {
        List<String> carsName = parsedCarsName(inputValue);
        for (String carName : carsName) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<String> getWinnersName() {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<String> parsedCarsName(String inputValue) {
        return Arrays.asList(inputValue.split(CAR_NAME_SEPARATOR));
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
