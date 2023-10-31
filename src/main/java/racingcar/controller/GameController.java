package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Player;
import racingcar.model.RacingGame;
import racingcar.util.Censor;
import racingcar.util.TypeTransducer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final Player player = new Player();
    private final RacingGame game = new RacingGame();
    private final Censor censor = new Censor();

    public void runGame() {
        setUpPlayer(TypeTransducer.strToList(getNickname()));
        setUpGameTime(getGameTime());
        play();
    }

    private void play() {
        OutputView.displayPlayResultTitle();
        for (int gameTurn = 0; gameTurn < player.getGameTime(); gameTurn++) {
            game.start(player.getPlayer());
            OutputView.displayGameProgress(player.getPlayer());
            OutputView.displayNextLine();
        }
        OutputView.displayGameWinner(player.getWinner());
    }

    private void setUpPlayer(List<String> playerList) {
        for (String nickname : playerList) {
            player.registerNickname(nickname);
        }
    }

    private void setUpGameTime(String gameTime) {
        player.registerGameTime(gameTime);
    }

    private String getNickname() {
        InputView.displaySetUpNickname();
        String input = Console.readLine();
        return validationNickname(input);
    }

    private String getGameTime() {
        InputView.displaySetUpPlayTime();
        String input = Console.readLine();
        return validationGameTime(input);
    }

    private String validationNickname(String input) {
        censor.checkInputForNickname(input);
        return input;
    }

    private String validationGameTime(String input) {
        censor.checkInputForGameTime(input);
        return input;
    }
}
