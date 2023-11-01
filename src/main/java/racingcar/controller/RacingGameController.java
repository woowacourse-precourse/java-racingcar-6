package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingGameService;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    private final RacingGameView racingGameView = new RacingGameView();

    private int gameAttempts;
    // game start
    public void gameInit() throws IllegalArgumentException{
        // 사용자 이름 입력
        racingGameView.printInputPlayersMsg();
        String nameInput = Console.readLine();
        //game 초기 세팅
        racingGameService.initGame(nameInput);
        // 게임 회수 입력 및 설정
        racingGameView.printInputGameTurnMsg();
        String attempts = Console.readLine();
        setGameAttempts(racingGameService.attemptParseToInt(attempts));
    }
    public void gameStart(){
        // game attempt 만큼 진행
        racingGameView.printInitResultMsg();
        for (int attempt =0; attempt <gameAttempts; attempt++){
            racingGameView.printTurnResultMsg(racingGameService.playTurn());
        }

    }
    public void setGameAttempts(int gameAttempts) {
        this.gameAttempts = gameAttempts;
    }
    // game end
    public void gameEnd(){
        racingGameView.printResultMsg(racingGameService.findWinners());
    }
}
