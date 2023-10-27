package racingcar.controller;

import java.util.List;
import racingcar.constants.GameMessage;
import racingcar.model.Car;
import racingcar.model.GameState;
import racingcar.utils.Converter;
import racingcar.view.InputView;

public class GameController {
    public void startGame() {
        String inputName = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_CAR_NAME.getMessage());
        List<String> names = Converter.convertStringToList(inputName);
        Car cars = new Car(names);

        String inputNumber = InputView.input(GameMessage.INSTRUCTIONS_ENTERING_ATTEMPT_NUMBER.getMessage());
        int number = Converter.convertStringToInt(inputNumber);
        GameState gameState = new GameState(number);
    }
}
