package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceController {
    private final InputView consoleInputView;
    private final ResultView consoleResultView;
    private final Race race;


    public RaceController(InputView consoleInputView, ResultView consoleResultView, Race race) {
        this.consoleInputView = consoleInputView;
        this.consoleResultView = consoleResultView;
        this.race = race;
    }

    public void runRace() {
        List<String> carNames = getValidatedCarNames();
        int roundNumber = getValidatedRoundNumber();
        List<Car> cars = initCars(carNames);
    }

    private List<String> getValidatedCarNames() {
        List<String> carNames = consoleInputView.getCarNamesInput();
        CarNameValidator.validate(carNames);
        return carNames;
    }

    private int getValidatedRoundNumber() {
        String roundNumber = consoleInputView.getRoundInput();
        RoundNumberValidator.validate(roundNumber);
        return Integer.parseInt(roundNumber);
    }

    private List<Car> initCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}