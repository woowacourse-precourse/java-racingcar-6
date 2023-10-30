package racingcar.controller;

import static racingcar.view.IOMessage.PRINT_RESULT;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.model.Result;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingGameController {
    public void run() {

        String inputCarNames = InputView.inputCarNames();
        RacingGame racingGame = RacingGame.from(inputCarNames);
        int tryCount = InputView.inputTryCount();

        playRacingGame(racingGame, tryCount);
    }
    private void printResults(List<Result> results) {
        results.forEach(OutPutView::printResult);
        OutPutView.println();
    }

    private void printWinnerResults(RacingGame racingGame) {
        List<String> winnerNameList = racingGame.determineRaceWinners();
        OutPutView.printWinner(winnerNameList);
    }

    private void playRacingGame(RacingGame racingGame, int tryCount) {
        OutPutView.println();
        OutPutView.printIOMessage(PRINT_RESULT);
        for (int i = 0; i < tryCount; i++) {
            List<Result> results = racingGame.play();
            printResults(results);
            if(i == tryCount - 1) printWinnerResults(racingGame);
        }
    }

}
