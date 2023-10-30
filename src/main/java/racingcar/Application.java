package racingcar;

import static constant.Message.COLON_WITH_WHITESPACE;
import static constant.Message.COMMA_WITH_WHITESPACE;
import static constant.Message.FINAL_WINNERS;

import controller.RacingCarController;
import View.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController racingCarController = new RacingCarController();

        View.printStartMessage();
        racingCarController.extractName(View.input());
        View.printRacingResultMessage();
        View.printCycleInputMessage();
        View.printRacingResult(racingCarController.racing(View.input()));
        View.printMessage(String.join(COLON_WITH_WHITESPACE.getMessage(), FINAL_WINNERS.getMessage(),
                String.join(COMMA_WITH_WHITESPACE.getMessage(), racingCarController.showResult())));
    }
}
