package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Service.RacingCarService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingCarController {
    RacingCarService game = new RacingCarService();
    public void run() {
        initGame();
        playGame();
    }

    private void initGame() {
        OutputView.printInputRacingCar();
        game.userInputRacingCar(getUserInput());
        OutputView.printInputRacingCount();
        game.userInputCount(getUserInput());
    }

    private void playGame() {
        game.play();
    }

    private static String getUserInput() {
        return InputView.getUserInput();
    }
}
