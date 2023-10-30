package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingGameService;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    private final RacingGameView racingGameView = new RacingGameView();

    // game start
    public void gameStart() throws IllegalArgumentException{
        racingGameView.printInputPlayersMsg();
        racingGameService.initGame(Console.readLine());

    }
    // game end
    public void gameEnd(){

    }
}
