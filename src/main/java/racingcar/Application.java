package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.Player;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Player player = new Player();

        Controller controller = new Controller(randomNumberGenerator, inputView, outputView, player);
        controller.run();
    }
}
