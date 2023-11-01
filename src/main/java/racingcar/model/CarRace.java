package racingcar.model;

import static racingcar.view.ExceptionMessage.NOT_LESS_THAN_ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class CarRace {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    private final int iteration;
    private List<Car> cars;
    public CarRace(List<Car> cars, int iteration) {
        validatePositiveNumber(iteration);
        this.iteration = iteration;
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

    public void runRaceWithIteration(int iteration) {
        for (int i = 0; i < iteration; i++) {
            runRace();
        }
    }

    private static void validatePositiveNumber(int intValue) {
        if (intValue <= 0) {
            throw new IllegalArgumentException(NOT_LESS_THAN_ZERO.getMessage());
        }
    }

    public int getIteration() {
        return iteration;
    }
}
