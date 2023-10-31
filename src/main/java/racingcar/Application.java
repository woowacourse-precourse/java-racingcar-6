package racingcar;

import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager(new InputView(), new OutputView(), new Referee());
        gameManager.launch();
    }
}
