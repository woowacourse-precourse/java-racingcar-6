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
        game.initGame();
        OutputView.printGameStart();
    }

    private void playGame() {
        while (!game.isWon()) {
            game.play();
            OutputView.printResult(game.getCarDtoList());
        }
        OutputView.printGameWinner(game.getGameWinner());
    }

    private static String getUserInput() {
        return InputView.getUserInput();
    }
}
