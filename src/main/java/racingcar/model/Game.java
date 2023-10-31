package racingcar.model;

import racingcar.model.validators.GameTryValidator;
import racingcar.model.validators.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Game {
    private int gameTry;
    private final Cars cars;
    private final List<Car> winners = new ArrayList<>();

    private Validator validator = new GameTryValidator();

    public Game(Cars cars, Integer gameTry) {
        validator.validate(gameTry);
        this.cars = cars;
        this.gameTry = gameTry;
    }

    public int getGameTry() {
        return gameTry;
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        CarComparator carComparator = new CarComparator();

        Car firstCar = cars.getCars().stream().sorted(carComparator::compare).findFirst().get();
        cars.getCars().stream().filter(car -> car.getPosition() == firstCar.getPosition()).forEach(car -> winners.add(car));

        return winners;
    }

    private class CarComparator implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            return o2.getPosition() - o1.getPosition();
        }
    }
}
