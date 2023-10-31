package racingcar.model.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.validate.Validate;

public class CarManager {

    private final List<Car> cars;

    public CarManager() {
        this.cars = new ArrayList<>();
    }

    public void saveCars(String input) {
        Validate.carNameLength(input);
        Validate.isNotNumber(input);
        String[] parts = input.split(",");
        for (String part : parts) {
            cars.add(new Car(part));
        }
    }

    public int size() {
        return this.cars.size();
    }

    public void moveCar(int index) {
        this.cars.get(index).increaseLocation();
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        cars.forEach(car -> names.add(car.getName()));
        return names;
    }

    public List<Integer> getLocations() {
        List<Integer> locations = new ArrayList<>();
        cars.forEach(car -> locations.add(car.getLocation()));
        return locations;
    }

    public int getMaxLocation() {
        return cars.stream()
                .max(Comparator.comparing(Car::getLocation))
                .get()
                .getLocation();
    }

    public List<Car> getCarsByLocation(int location) {
        return cars.stream()
                .filter(car -> car.getLocation() == location)
                .collect(Collectors.toList());
    }
}