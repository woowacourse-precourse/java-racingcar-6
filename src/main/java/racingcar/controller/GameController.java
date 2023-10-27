package racingcar.controller;

import java.util.List;
import racingcar.constants.GameMessage;
import racingcar.model.Car;
import racingcar.utils.Converter;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void startGame() {
        String inputName = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_CAR_NAME.getMessage());
        List<String> names = Converter.convertStringToList(inputName);
        Validator.validateCarName(names);

        String inputNumber = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_ATTEMPT_NUMBER.getMessage());
        int number = Converter.convertStringToInt(inputNumber);

        Car cars = new Car(names, number);

        racing(cars);
    }

    public void racing(Car cars){
        OutputView.displayTitle();
        for(int i = 0; i < cars.getAttempt(); i ++) {
            cars.forward();
            OutputView.displayRacingSituation(cars);
        }
    }
}
