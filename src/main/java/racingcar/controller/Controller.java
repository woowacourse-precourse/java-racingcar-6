package racingcar.controller;

import java.util.List;
import racingcar.dto.RoundDTO;
import racingcar.model.RacingGame;
import racingcar.model.Winner;
import racingcar.utils.validation.ValidateAttempts;
import racingcar.utils.validation.ValidateCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private RacingGame game;
    private Winner winner = new Winner();
    InputView input = new InputView();
    OutputView output = new OutputView();


    public void playGame() {
        createGameSession();
        game.proceedGame();
        displayGameResult();
    }


    // 게임 정보를 입력받아 그것을 기반으로 RacingGame 세션 생성, 게임 진행
    private void createGameSession() {
        String[] cars = askAndGetCarList();
        int attempts = askAndGetAttempts();
        game = new RacingGame(cars, attempts);
    }

    // 게임 결과를 받아와 OutputView에 출력
    private void displayGameResult() {
        List<RoundDTO> rounds = game.getRoundDTO();
        List<String> winners = winner.getWinners(rounds);

        output.displayResult(rounds, winners);
    }

    // InputView를 통해 자동차 목록 입력받기
    private String[] askAndGetCarList() {
        String[] carList = input.askForCarNames();
        ValidateCars.isValid(carList);

        return carList;
    }

    // InputView를 통해 시도 횟수 입력받기
    private int askAndGetAttempts() {
        String tmp = input.askForAttempts();
        ValidateAttempts.isValid(tmp);
        int attempts = Integer.parseInt(tmp);

        return attempts;
    }

}
