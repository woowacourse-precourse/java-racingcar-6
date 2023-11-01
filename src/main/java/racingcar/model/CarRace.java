package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarRace {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
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
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            car.goOrStop(randomNumber);
        }
    }

    public int getIteration() {
        return iteration.value();
    }
}
