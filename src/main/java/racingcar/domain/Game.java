package racingcar.domain;

import java.util.List;
import racingcar.utils.WinnerFinder;
import racingcar.utils.CarListCreator;
import racingcar.validator.CarNameValidator;

public class Game {

    private static final String NAME_DELIMITER = ",";

    private List<Car> cars;

    public Game(String carNames) {
        String[] splitCarNames = splitCarNames(carNames);
        CarNameValidator.validateCarNames(splitCarNames);
        this.cars = CarListCreator.createCarsList(splitCarNames);
    }

    public Game(String carNames, NumberGenerator numberGenerator) {
        String[] splitCarNames = splitCarNames(carNames);
        CarNameValidator.validateCarNames(splitCarNames);
        this.cars = CarListCreator.createCarsList(splitCarNames, numberGenerator);
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.split(NAME_DELIMITER);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinners() {
        return WinnerFinder.findWinners(cars);
    }
}
