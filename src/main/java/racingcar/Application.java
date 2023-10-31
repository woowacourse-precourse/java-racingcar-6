package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.MovePossibilityChecker;
import racingcar.domain.RandomNumberGenerator;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        //TODO: gitignore - .class 파일 어케해?
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        InputView inputView = new InputView(reader, writer);
        OutputView outputView = new OutputView(writer);
        MovePossibilityChecker movePossibilityChecker = new MovePossibilityChecker(new RandomNumberGenerator());
        GameController gameController = new GameController(inputView, outputView, movePossibilityChecker);
        gameController.start();
    }
}
