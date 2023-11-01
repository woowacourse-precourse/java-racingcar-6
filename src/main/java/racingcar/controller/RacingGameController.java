package racingcar.controller;

import static racingcar.view.IOMessage.PRINT_RESULT;

import java.util.List;
import racingcar.service.RacingGameService;
import racingcar.model.Result;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingGameController {
    public void run() {

        String inputCarNames = InputView.inputCarNames();
        RacingGameService racingGameService = RacingGameService.from(inputCarNames);
        int tryCount = InputView.inputTryCount();

        playRacingGame(racingGameService, tryCount);
    }
    private void printResults(List<Result> results) {
        results.forEach(OutPutView::printResult);
        OutPutView.println();
    }

    private void printWinnerResults(RacingGameService racingGameService) {
        List<String> winnerNameList = racingGameService.determineRaceWinners();
        OutPutView.printWinner(winnerNameList);
    }

    private void playRacingGame(RacingGameService racingGameService, int tryCount) {
        printBeforeResultsMessage();
        for (int i = 0; i < tryCount; i++) {
            List<Result> results = racingGameService.play();
            printResults(results);
            if(i == tryCount - 1) printWinnerResults(racingGameService);
        }
    }

    private static void printBeforeResultsMessage() {
        OutPutView.println();
        OutPutView.printIOMessage(PRINT_RESULT);
    }

}
