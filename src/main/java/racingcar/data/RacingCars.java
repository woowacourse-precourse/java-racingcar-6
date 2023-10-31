package racingcar.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;
    private static final int INIT_POS = 0;
    private static final String RACING_CARS_DELIMITER = "\n";

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public RacingCars(RacingCars racingCars) {
        this.cars = new ArrayList<>(racingCars.cars);
    }

    public void createCar(String name) {
        Car newCar = new Car(name, INIT_POS);
        cars.add(newCar);
    }

    public void moveCar(int carIndex, int moveNum) {
        cars.get(carIndex).moveCarPosition(moveNum);
    }

    public int isTotal() {
        return cars.size();
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(RACING_CARS_DELIMITER));
    }
}
