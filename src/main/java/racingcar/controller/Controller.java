package racingcar.controller;

import racingcar.model.CarManager;
import racingcar.model.RacingGame;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    CarManager manager = new CarManager();
    Winners winners = new Winners(manager);
    RacingGame game;
    InputView input = new InputView();
    OutputView output = new OutputView();


    public void playGame() {
        setGameSession();
        proceedGame();

        String gameResult = winners.getWinners();
        output.displayWinners(gameResult);
    }


    // View에서 받은 자동차 이름을 토대로 자동차 생성 요청
    private String[] askAndGenerateCars() {
        String[] carsList = input.askForCarNames();
        manager.createAndAddCars(carsList);

        return carsList;
    }

    // View에서 받은 시도 횟수를 설정 파일에 전달
    private int askAndGetAttempts() {
        int attempts = input.askForAttempts();
        return attempts;
    }

    // 게임 정보를 입력받고 그것을 기반으로 RacingGame 세션 생성
    private void setGameSession() {
        String[] cars = askAndGenerateCars();
        int carAmount = cars.length;
        int attempts = askAndGetAttempts();

        game = new RacingGame(manager, carAmount, attempts);
        output.startDisplayResult();
    }

    // 정해진 시도 횟수만큼 라운드별 진행을 요청, 라운드마다 결과 출력
    private void proceedGame() {
        boolean isContinue;
        int round = 1;

        do {
            game.playRound();
            displayRound();
            round++;

            isContinue = game.inContinueRound(round);
        } while (isContinue);
    }

    // 라운드가 끝난 후 결과 출력
    private void displayRound() {
        String roundResult = game.getRoundResult();
        output.display(roundResult);
    }

}
