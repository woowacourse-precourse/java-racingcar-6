package racingcar.model;

import static racingcar.util.RandomGenerator.pickNumber;

import java.util.List;

public class CarRace {

    private final Iteration iteration;
    private List<Car> cars;

    public CarRace(List<Car> cars, int iteration) {
        this.iteration = new Iteration(iteration);
        this.cars = cars;
    }

    public List<Car> getWinner() {
        int highestLocation = cars.stream().mapToInt(Car::getLocation).max().getAsInt();
        return cars.stream().filter(car -> car.getLocation() == highestLocation).toList();
    }

    public void runRace() {
        for (Car car : cars) {
            car.goOrStop(pickNumber());
        }
    }

    public int getIteration() {
        return iteration.value();
    }
}
