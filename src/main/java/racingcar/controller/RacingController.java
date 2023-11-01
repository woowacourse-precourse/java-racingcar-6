package racingcar.controller;

import java.util.List;
import racingcar.domain.Count;
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
        final Count countOfMoving = initializeCountOfMoving();

        printResultTitle();
        countOfMoving.repeat(() -> progress(racing));
        printWinner(racing);
    }

    private Racing initializeRacing() {
        List<String> names = inputView.inputNames();
        return Racing.from(names);
    }

    private Count initializeCountOfMoving() {
        int countOfMoving = inputView.inputCountOfTry();
        return Count.from(countOfMoving);
    }

    private void printResultTitle() {
        outputView.printRacingResultTitle();
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
