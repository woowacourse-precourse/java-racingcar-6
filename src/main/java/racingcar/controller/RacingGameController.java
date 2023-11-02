package racingcar.controller;

import racingcar.Util.GameGuideMessage;
import racingcar.service.RacingGameService;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
    }


    public void startRacingGame() {
        System.out.println(GameGuideMessage.PARTICIPATING_CAR.getMessage());
        racingGameService.acceptCarList(); // 참가할 자동차 이름을 입력받음

        System.out.println(GameGuideMessage.MOVEMENT_COUNT.getMessage());
        racingGameService.acceptRound(); // 시도할 회수를 입력받음
    }

    public void showGameResult() {
        System.out.println("\n" + GameGuideMessage.RESULT.getMessage());
        racingGameService.proceedRace(); // 게임을 진행함
    }

    public void showWinner() {
        System.out.print(GameGuideMessage.WINNER.getMessage());
        String winnerList = racingGameService.decideWinner(); // 우승자를 구함.
        System.out.println(winnerList);
    }


}
