package racingcar.model.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.validate.Validate;

public class Cars {

    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public void saveCars(String input) {
        Validate.carNameLength(input);
        Validate.isNotNumber(input);
        String[] parts = input.split(",");
        for (String part : parts) {
            carList.add(new Car(part));
        }
    }

    public int size() {
        return this.carList.size();
    }

    public void moveCar(int index) {
        this.carList.get(index).increaseLocation();
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        carList.forEach(car -> names.add(car.getName()));
        return names;
    }

    public List<Integer> getLocations() {
        List<Integer> locations = new ArrayList<>();
        carList.forEach(car -> locations.add(car.getLocation()));
        return locations;
    }

    public int getMaxLocation() {
        return carList.stream()
                .max(Comparator.comparing(Car::getLocation))
                .get()
                .getLocation();
    }

    public List<Car> getCarsByLocation(int location) {
        return carList.stream()
                .filter(car -> car.getLocation() == location)
                .collect(Collectors.toList());
    }
}