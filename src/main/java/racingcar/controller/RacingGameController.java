package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCarGameMachine;
import racingcar.model.ValidatePlayerInput;
import racingcar.view.GameMessage;

import java.util.List;

public class RacingGameController {
    private RacingCarGameMachine racingCarGameMachine = new RacingCarGameMachine();
    private ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();

    public void play() {
        System.out.println(GameMessage.START_MESSAGE.getStartMessage());
        String carNames = Console.readLine();
        validatePlayerInput.validateContainSpace(carNames);
        validatePlayerInput.validateCarNameLength(carNames);
        List<String> names = validatePlayerInput.convertStringToListCarNames(carNames);

        System.out.println(GameMessage.REQUEST_TRY_MESSAGE.getRequestTryMessage());
        String tryCount = Console.readLine();
        validatePlayerInput.validatePlayerTryCountInput(tryCount);

        System.out.println(GameMessage.GAME_RESULT_MESSAGE.getGameResultMessage());
        racingCarGameMachine.gamePlay(names, Integer.parseInt(tryCount));
        List<String> winners = racingCarGameMachine.winner();
        System.out.print(GameMessage.WINNER_MESSAGE.getWinnerMessage());
        for (String winner : winners) {
            System.out.print(winner);
        }
    }
}
