package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.utils.Converter;
import racingcar.view.InputView;

public class GameController {
    public void startGame() {
        String input = InputView.inputCarNames();
        List<String> names = Converter.convertStringToList(input);
        System.out.println(names);

        Car cars = new Car(names);
    }
}
