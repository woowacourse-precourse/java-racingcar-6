package racingcar;

import java.util.ArrayList;
import java.util.List;


public class NCars {
    private List<Car> cars;

    private NCars(final List<Car> cars) {
        this.cars = cars;
    }

    public static NCars applyNames(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.applyName(name));
        }
        return new NCars(cars);
    }

    public List<String> getNamesForTest() {
        List<String> names = new ArrayList<>();
        for (Car car : this.cars) {
            names.add(car.toString());
        }
        return names;
    }

    public List<Integer> moveCars() {
        List<Integer> carsPositions = new ArrayList<>();
        for (Car car : this.cars) {
            carsPositions.add(car.changePosition(
                    CarMovementStatus.getMovementStatusByCheckNumber(
                            RandomNumberGenerator.getRandomNUmber())));
        }
        return carsPositions;
    }

    public List<List<Integer>> moveCarsRepeatedByRound(Integer round) {
        List<List<Integer>> carsPositions = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            carsPositions.add(moveCars());
        }
        return carsPositions;
    }
}
