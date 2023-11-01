package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Game;
import racingcar.view.RepeatingGameView;

public class RacingCarGameController implements GameController {
    private final Game game;
    private final RepeatingGameView gameView;
    private boolean playGame = true;

    public RacingCarGameController(Game game, RepeatingGameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    @Override
    public void play() {
        String[] input = new String[2];
        gameView.showInputRequiredMessage();
        input[0] = Console.readLine();
        gameView.showRepeatingNumberRequiredMessage();
        input[1] = Console.readLine();

        game.play(input);
        race();
        gameView.showResultOf(game);
        quitGame();
    }

    @Override
    public void quitGame() {
        playGame = false;
    }

    public void race() {
        while (game.continues()) {
            game.play(null);
            gameView.showProgressOf(game);
        }
    }
}
