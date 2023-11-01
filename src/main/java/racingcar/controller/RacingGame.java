package racingcar.controller;

import static racingcar.service.RacingGameService.end;
import static racingcar.service.RacingGameService.proceedAwardStage;
import static racingcar.service.RacingGameService.proceedCarNameInputStage;
import static racingcar.service.RacingGameService.proceedPlayNumberInputStage;
import static racingcar.service.RacingGameService.proceedPlayStage;


public class RacingGame {

    public static void run() {

        proceedCarNameInputStage();

        proceedPlayNumberInputStage();

        proceedPlayStage();

        proceedAwardStage();

        end();
    }
}
