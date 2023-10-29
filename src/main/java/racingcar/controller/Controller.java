package racingcar.controller;

import static racingcar.config.Settings.ROUND_MAX;

import racingcar.config.Settings;
import racingcar.model.CarManager;
import racingcar.model.RacingGame;
import racingcar.view.View;

public class Controller {
    CarManager manager = new CarManager();
    RacingGame game = new RacingGame(manager);

    public void startGame() {
        askAndGenerateCars();
        askAndSetAttempts();

        View.displayResult();
        playRace();
        String winners = game.getWinners();

        View.displayWinners(winners);
    }


    // View에서 받은 자동차 이름을 토대로 자동차 생성 요청
    private void askAndGenerateCars() {
        String[] cars = View.askForCarNames();
        manager.createAndAddCars(cars);
    }

    // View에서 받은 시도 횟수를 설정 파일에 전달
    private void askAndSetAttempts() {
        int attempts = View.askForAttempts();
        Settings.setRound(attempts);
    }

    // 정해진 시도 횟수만큼 라운드별 진행을 요청, 라운드가 끝날 때마다 결과 출력
    private void playRace() {
        for (int round = 0; round < ROUND_MAX; round++) {
            String roundResult = game.playRound();
            View.displayRoundResult(roundResult);
        }
    }

}
