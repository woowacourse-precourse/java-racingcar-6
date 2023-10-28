package racingcar.controller;

import static racingcar.util.messageContent.ExceptionMessageContent.NICKNAME_LENGTH_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Player;
import racingcar.util.Censor;
import racingcar.util.TypeTransducer;
import racingcar.view.InputView;

public class GameController {

    private final Player player = new Player();
    private final TypeTransducer typeTransducer = new TypeTransducer();
    private final Censor censor = new Censor();

    public void runGame() {
        setUpPlayer(typeTransducer.strToList(getNickname()));
    }

    private void setUpPlayer(List<String> playerList) {
        for (String nickname : playerList) {
            player.register(nickname);
        }
    }

    private String getNickname() {
        InputView.displaySetUpNickname();
        String input = Console.readLine();
        return validationNickname(input);
    }

    private String validationNickname(String input) {
        if (!censor.checkLength(input)) {
            throw new IllegalArgumentException(NICKNAME_LENGTH_ERROR.getContent());
        }
        return input;
    }
}
