package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.ConsoleView;
import racingcar.validation.InputValidator;
public class GameController {
    private ConsoleView view;

    public GameController(ConsoleView view) {
        this.view = view;
    }

    public void startGame() {
        String carNames = view.readCarNames();
        InputValidator.validateInputFormat(carNames);

        List<Car> cars = createCars(Arrays.asList(carNames.split(",")));
        Race race = new Race(cars);

        int movement = view.readMovement();
        InputValidator.validateMovement(movement);

        view.printGameStartMessage();

        for (int i = 0; i< movement ; i++){
            race.run(1);
            view.printRaceStatus(cars);
        }

        List<String> winners = race.getWinners();
        view.printWinners(winners);
    }

    private List<Car> createCars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNameList) {
            InputValidator.validateCarName(name);
            cars.add(new Car(name));
        }
        return cars;
    }
}