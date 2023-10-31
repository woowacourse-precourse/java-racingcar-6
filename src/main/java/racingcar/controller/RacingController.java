package racingcar.controller;

import java.util.List;
import racingcar.domain.Racing;
import racingcar.dto.RacingResultDto;
import racingcar.dto.WinnerDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView = InputView.createConsoleView();
    private final OutputView outputView = OutputView.createConsoleView();

    public void run() {
        final Racing racing = initializeRacing();
        final int countOfMoving = initializeCountOfMoving();

        printResultTitle();
        repeat(countOfMoving, () -> progress(racing));
        printWinner(racing);
    }

    private Racing initializeRacing() {
        List<String> names = inputView.inputNames();
        return Racing.from(names);
    }

    private int initializeCountOfMoving() {
        return inputView.inputCountOfTry();
    }

    private void printResultTitle() {
        outputView.printRacingResultTitle();
    }

    private void repeat(int count, Runnable action) {
        for (int currentCount = 0; currentCount < count; currentCount++) {
            action.run();
        }
    }

    private void progress(Racing racing) {
        racing.move();

        RacingResultDto result = RacingResultDto.from(racing);
        outputView.printRacingResult(result);
    }

    private void printWinner(Racing racing) {
        WinnerDto winner = WinnerDto.from(racing);
        outputView.printWinner(winner);
    }
}
