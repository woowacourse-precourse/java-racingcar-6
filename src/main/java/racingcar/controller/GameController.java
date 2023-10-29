package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Player;
import racingcar.model.RacingGame;
import racingcar.util.Censor;
import racingcar.util.TypeTransducer;
import racingcar.view.InputView;

public class GameController {

    private final Player player = new Player();
    private final RacingGame game = new RacingGame();
    private final TypeTransducer typeTransducer = new TypeTransducer();
    private final Censor censor = new Censor();

    public void runGame() {
        setUpPlayer(typeTransducer.strToList(getNickname()));
        setUpGame(Integer.parseInt(getGameTime()));
    }

    private void setUpPlayer(List<String> playerList) {
        for (String nickname : playerList) {
            player.register(nickname);
        }
    }

    private void setUpGame(Integer gameTime) {
        // TODO: 비즈니스 로직을 수행할 메소드 호출
        game.register(gameTime);
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
