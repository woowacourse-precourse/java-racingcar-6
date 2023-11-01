package racingcar.controller;

import static racingcar.domain.RacingGameManager.proceedAwardStage;
import static racingcar.domain.RacingGameManager.proceedCarNameInputStage;
import static racingcar.domain.RacingGameManager.proceedPlayNumberInputStage;
import static racingcar.domain.RacingGameManager.proceedPlayStage;


public class RacingGame {

    public static void run() {

        proceedCarNameInputStage();

        proceedPlayNumberInputStage();

        proceedPlayStage();

        proceedAwardStage();
    }
}
