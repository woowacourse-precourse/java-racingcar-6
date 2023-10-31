package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingGameService;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    private final RacingGameView racingGameView = new RacingGameView();

    // game start
    public void gameStart() throws IllegalArgumentException{
        // 사용자 이름 입력
        racingGameView.printInputPlayersMsg();
        String nameInput = Console.readLine();
        // 게임 회수 입력
        racingGameView.printInputGameTurnMsg();
        String attempts = Console.readLine();

        racingGameService.initGame(nameInput,attempts);

    }
    // game end
    public void gameEnd(){

    }
}
