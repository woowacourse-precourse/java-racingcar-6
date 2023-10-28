package racingcar;

import racingcar.controller.GameController;
import racingcar.converter.InputConverter;
import racingcar.util.InputValidator;
import racingcar.util.NumberPicker;
import racingcar.util.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputValidator inputValidator = new InputValidator();
        InputConverter inputConverter = new InputConverter();
        InputView inputView = new InputView(inputValidator, inputConverter);
        OutputView outputView = new OutputView();
        NumberPicker randomNumberPicker = new RandomNumberPicker(0, 9);
        GameController gameController = new GameController(inputView, outputView, randomNumberPicker);
        gameController.run();
    }
}
