package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.io.Input;
import racingcar.service.GameService;

public class GameController {
    private static final String EXECUTION_RESULT = "실행 결과";
    private RacingGame racingGame;

    public void initGame() {
        List<String> names = Input.carNames();
        int finalRound = Input.gameRound();
        this.racingGame = new RacingGame(finalRound, names);
    }

    public void playGame() {
        System.out.println(EXECUTION_RESULT);
        while (!racingGame.isFinalRound()) {
            GameService.playSingleRound(racingGame);
            //각 라운드 종료후 게임 결과 출력 기능 추가
        }
    }

    public void endGame() {
        List<Car> winners = GameService.getWinners(racingGame.getCars());
        //우승자 출력 기능 추가
    }
}
