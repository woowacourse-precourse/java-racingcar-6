package racingcar;

import racingcar.validation.CarInputValidation;
import racingcar.validation.MoveCountsValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        CarInputValidation carInputValidation = new CarInputValidation();
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();
        InputView inputView = new InputView(carInputValidation, moveCountsValidation);
        Race race = new Race();
        MainController mainController = new MainController(outputView, inputView, race);
        mainController.startGame();
    }
}
