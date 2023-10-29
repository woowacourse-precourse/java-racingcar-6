package racingcar.view;

import java.util.List;
import racingcar.domain.result.RacingCarResult;

public class OutputView {

    public void inputCarsNames() {
        System.out.println(Messages.INPUT_CARS_MESSAGE);
    }

    public void inputTrial() {
        System.out.println(Messages.INPUT_TRIAL_MESSAGE);
    }

    public void showRacingResult(List<RacingCarResult> results) {
        System.out.println();
        System.out.println(Messages.RESULT_MESSAGE);
        for (RacingCarResult result : results) {
            System.out.println(result.getResultMessage());
        }
    }
}
