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
        int countOfMoving = inputView.inputCountOfTry();
        validateCountOfMoving(countOfMoving);

        return countOfMoving;
    }

    private void validateCountOfMoving(int countOfMoving) {
        if (countOfMoving <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상 이어야 합니다");
        }
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
