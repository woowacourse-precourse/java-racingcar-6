package racingcar.controller;

import java.util.List;
import racingcar.constants.GameMessage;
import racingcar.model.Car;
import racingcar.utils.Converter;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private List<String> names;
    private int attempt;

    public void startGame() {
        getUserInputs();

        Car cars = new Car(names, attempt);

        racing(cars);
    }

    public void getUserInputs() {
        String inputName = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_CAR_NAME.getMessage());
        names = Converter.convertStringToList(inputName);
        validate(names);

        String inputAttempt = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_ATTEMPT_NUMBER.getMessage());
        attempt = Converter.convertStringToInt(inputAttempt);
    }

    private void racing(Car cars){
        OutputView.displayTitle();
        for(int i = 0; i < cars.getAttempt(); i ++) {
            cars.forward();
            OutputView.displayRacingSituation(cars);
        }
        cars.initWinners();
        OutputView.displayWinner(cars);
    }

    private void validate(List<String> names) {
        Validator.validateCarName(names);
        Validator.validateNotDuplicate(names);
    }
}
