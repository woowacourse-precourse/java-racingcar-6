package racingcar.controller;

import java.util.List;
import racingcar.constants.ErrorMessage;
import racingcar.constants.GameMessage;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.utils.Converter;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final Cars cars;

    public GameController() {
        this.cars = new Cars();
    }

    public void startGame() {
        try {
            List<String> names = initNames();
            int attempt = initAttempt();

            initCars(names);

            OutputView.displayTitle();

            racing(attempt);

            OutputView.displayWinner(new Winners(cars));
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OCCURRED.getMessage());
        }
    }

    public void initCars(List<String> names) {
        for (String name : names) {
            cars.addCar(new Car(name));
        }
    }

    public void racing(int attempt) {
        for (int i = 0; i < attempt; i++) {
            cars.forward();
            OutputView.displayRacingSituation(cars);
        }
    }

    public List<String> initNames() {
        String inputName = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_CAR_NAME.getMessage());
        List<String> names = Converter.convertStringToList(inputName);
        validate(names);
        return names;
    }

    public int initAttempt() {
        String inputAttempt = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_ATTEMPT_NUMBER.getMessage());
        validate(inputAttempt);
        return Converter.convertStringToInt(inputAttempt);
    }

    private void validate(List<String> names) {
        Validator.validateCarName(names);
        Validator.validateNotDuplicate(names);
        Validator.validateNoSpace(names);
    }

    private void validate(String attempt) {
        Validator.validateNumber(attempt);
        Validator.validateNotZero(attempt);
    }
}
