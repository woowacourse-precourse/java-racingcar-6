package racingcar.controller;

import static racingcar.model.RacingGameService.end;
import static racingcar.model.RacingGameService.proceedAwardStage;
import static racingcar.model.RacingGameService.proceedCarNameInputStage;
import static racingcar.model.RacingGameService.proceedPlayNumberInputStage;
import static racingcar.model.RacingGameService.proceedPlayStage;


public class RacingGame {

    public static void run() {

        proceedCarNameInputStage();

        proceedPlayNumberInputStage();

        proceedPlayStage();

        proceedAwardStage();

        end();
    }
}
