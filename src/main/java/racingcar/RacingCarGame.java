package racingcar;

import static racingcar.constant.Message.COLON_WITH_WHITESPACE;
import static racingcar.constant.Message.COMMA_WITH_WHITESPACE;
import static racingcar.constant.Message.FINAL_WINNERS;

import racingcar.View.View;
import racingcar.controller.RacingCarController;

public class RacingCarGame {

    private RacingCarController racingCarController = new RacingCarController();

    public void play() {
        View.printStartMessage();
        racingCarController.extractName(View.input());
        View.printRacingResultMessage();
        View.printCycleInputMessage();
        View.printRacingResult(racingCarController.racing(View.input()));
        View.printMessage(String.join(COLON_WITH_WHITESPACE.getMessage(), FINAL_WINNERS.getMessage(),
                String.join(COMMA_WITH_WHITESPACE.getMessage(), racingCarController.showResult())));
    }

}
