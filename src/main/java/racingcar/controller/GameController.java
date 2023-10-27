package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputVeiw;
import racingcar.view.OutputView;

/**
 * RoundController를 분리
 */
public class GameController {
    private static final InputVeiw inputView = new InputVeiw();
    private static final OutputView outputView = new OutputView();
    private Car raceCar;
    private Game game;

    public GameController() {
    }

    public void startGame() {
        // 차이름, 횟수 입력받기
        Game game = new Game(inputView.inputRoundNumber());
        raceCar = new Car(inputView.inputCarName());

        // while 라운드 체크 하며, 게임 수행
        do {
            game.increaseCurrentRound();

            // 게임 수행
            startRound();

        } while (game.getCurrentRound() < Game.MAX_ROUND);

        // 우승자 출력
    }

    private void startRound() {
        // raceCar 별로 랜덤값 생성

        // 조건 충족시, raceCar 이동
    }

}