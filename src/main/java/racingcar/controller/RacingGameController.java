package racingcar.controller;

import racingcar.model.CarStatus;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.view.PrintMessage.PRINT_RESULT;

public class RacingGameController {
    
    public void run() {
        String inputCarNames = InputView.inputCarNames();
        RacingGameService racingGameService = RacingGameService.make(inputCarNames);
        playRacingGame(racingGameService, InputView.inputTryCount());
    }

    private void playRacingGame(RacingGameService racingGameService, int tryCnt) {
        printBeforeResultsMessage();
        for (int i=0; i<tryCnt; i++) {
            List<CarStatus> carStatuses = racingGameService.play();
            printCarStatus(carStatuses);
            if(i == tryCnt-1)
                printWinners(racingGameService);
        }
    }

    private void printCarStatus(List<CarStatus> carStatuses) {
        carStatuses.forEach(OutputView::printCarStatus);
        OutputView.println();
    }

    private static void printBeforeResultsMessage() {
        OutputView.println();
        OutputView.printMessage(PRINT_RESULT);
    }

    private void printWinners(RacingGameService racingGameService) {
        List<String> winnerNameList = racingGameService.getRaceWinners();
        OutputView.printWinner(winnerNameList);
    }
}