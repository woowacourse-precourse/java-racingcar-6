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
        userInputRacingCar();
        userInputRacingCount();
        initAndStart();
    }

    private void userInputRacingCar() {
        OutputView.printInputRacingCar();
        game.userInputRacingCar(getUserInput());
    }

    private void userInputRacingCount() {
        OutputView.printInputRacingCount();
        game.userInputCount(getUserInput());
    }

    private void initAndStart() {
        game.initGame();
        OutputView.printGameStart();
    }

    private void playGame() {
        while (!game.isWon()) {
            game.play();
            printResult(game.makeMidPrint());
        }
        printGameWinner(game.getGameWinner());
    }

    private void printResult(String result) {
        OutputView.printResult(result);
    }
    private void printGameWinner(String gameWinner) {
        OutputView.printGameWinner(gameWinner);
    }

    private static String getUserInput() {
        return InputView.getUserInput();
    }
}
