package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Model.RacingGame;
import racingcar.View.RacingGameView;

import java.util.List;

public class RacingGameController {
    private final RacingGameView view;
    private RacingGame racingGame;

    public RacingGameController() {
        this.view = new RacingGameView();
    }

    public void startGame() {
        // 자동차 이름 및 시도 횟수 입력 받기
        List<String> carNames = view.getCarNames();
        int tryCount = view.getTryCount();

        // RacingGame 초기화
        racingGame = new RacingGame(carNames, tryCount);

        // RacingGame 진행
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            view.printRoundResult(racingGame.getCars());
        }

        // 최종 우승자 출력
        List<Car> winners = racingGame.getWinners();
        view.printWinners(winners);
    }

    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController();
        controller.startGame();
    }
}
