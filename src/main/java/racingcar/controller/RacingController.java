package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;


    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingService = new RacingService();
    }

    public void start() {
        requestCarNames();
        requestAttemptNumber();
        race();
        showWinner();
    }

    private void requestCarNames(){
        inputView.printRequestCarName();
        racingService.saveCarNames(Console.readLine());
    }

    private void requestAttemptNumber(){
        inputView.printRequestAttemptsNumber();
        racingService.saveAttemptNumber(Console.readLine());
    }

    private void race() {
        outputView.printRacingStartMessage();
        List<String> carNames = racingService.getCarNamesList();
        while(racingService.isContinue()) {
            outputView.printRoundResult(carNames, racingService.race());//racingService.race()는 race를 실행하고 race 결과를 반환합니다.
        }
    }

    private void showWinner() {
        outputView.printWinner(racingService.findWinners());
    }
}
