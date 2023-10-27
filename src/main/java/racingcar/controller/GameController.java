package racingcar.controller;

import java.util.List;
import racingcar.constants.GameMessage;
import racingcar.model.Car;
import racingcar.utils.Converter;
import racingcar.view.InputView;

public class GameController {
    public void startGame() {
        String inputName = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_CAR_NAME.getMessage());
        List<String> names = Converter.convertStringToList(inputName);
        Car cars = new Car(names);

        String inputNumber = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_ATTEMPT_NUMBER.getMessage());
    }
}
