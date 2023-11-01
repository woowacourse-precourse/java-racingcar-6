package racingcar;

import racingcar.domain.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        String carNames = game.inputCarNames();
        game.generateCarsByCarNames(carNames);
        game.inputTrialCount();

        game.playGame();

        game.judgeWinners();
        game.printWinners();
    }
}
