package racingcar.controller;

import static racingcar.config.Settings.ROUND_MAX;

import racingcar.config.Settings;
import racingcar.model.CarManager;
import racingcar.model.RacingGame;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    CarManager manager = new CarManager();
    RacingGame game = new RacingGame(manager);
    Winners winners = new Winners(manager);

    public void playGame() {
        askAndGenerateCars();
        askAndSetAttempts();

        OutputView.startDisplayResult();
        proceedGame();

        String gameResult = winners.getWinners();
        OutputView.displayWinners(gameResult);
    }


    // View에서 받은 자동차 이름을 토대로 자동차 생성 요청
    private void askAndGenerateCars() {
        String[] cars = InputView.askForCarNames();
        manager.createAndAddCars(cars);
    }

    // View에서 받은 시도 횟수를 설정 파일에 전달
    private void askAndSetAttempts() {
        int attempts = InputView.askForAttempts();
        Settings.setRound(attempts);
    }

    // 정해진 시도 횟수만큼 라운드별 진행을 요청, 라운드마다 결과 출력
    private void proceedGame() {
        for (int round = 0; round < ROUND_MAX; round++) {
            game.playRound();
            displayRound();
        }
    }

    // 라운드가 끝난 후 결과 출력
    private void displayRound() {
        String roundResult = game.getRoundResult();
        OutputView.display(roundResult);
    }

}
