package racingcar.data.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;
    private static final int INIT_POS = 0;
    private static final String RACING_CARS_DELIMITER = "\n";
    private static final String DUPLICATE_EXCEPTION = "CarNames should be distinct.";

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public RacingCars(RacingCars racingCars) {
        this.cars = new ArrayList<>(racingCars.cars);
    }

    public void createCar(String name) {
        Car newCar = new Car(name, INIT_POS);
        validateRacingCarsName(cars, name);
        cars.add(newCar);
    }

    public void moveCar(int carIndex, int moveNum) {
        cars.get(carIndex).moveCarPosition(moveNum);
    }

    public int isTotal() {
        return cars.size();
    }

    public int findFurthestPos() {
        int furthestPos = INIT_POS;
        for (Car car : cars) {
            if (furthestPos < car.getPosition()) {
                furthestPos = car.getPosition();
            }
        }
        return furthestPos;
    }

    public List<String> findPlayersByPos(int pos) {
        List<String> players = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSamePosition(pos)) {
                players.add(car.getName());
            }
        }
        return players;
    }

    public static void validateRacingCarsName(List<Car> cars, String name) {
        boolean hasName = cars.stream()
                .map(Car::getName)
                .anyMatch(name::equals);
        if (hasName) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(RACING_CARS_DELIMITER));
    }
}
