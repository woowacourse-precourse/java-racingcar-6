package racingcar.service;

import racingcar.console.Input;
import racingcar.console.Output;
import racingcar.constants.Constants;
import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final RaceManager raceManager;

    public Race() {
        List<Car> cars = initializeCars();
        this.raceManager = new RaceManager(cars);
    }

    public void start() {
        int rounds = getRounds();
        raceManager.startRace(rounds);
        printRaceResult();
    }

    private List<Car> initializeCars() {
        List<Car> cars = new ArrayList<>();
        String carNames = Input.getCarNames();
        for (String name : carNames.split(Constants.CAR_DELIMITER.getValue())) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private int getRounds() {
        return Input.getRounds();
    }

    private void printRaceResult() {
        for (Car car : raceManager.getCars()) {
            Output.printCarState(car.getName(), car.getPosition());
            Output.printNewLine();
        }
        Output.printWinner(String.join(Constants.NAME_SEPARATOR.getValue(), raceManager.getWinners()));
    }
}