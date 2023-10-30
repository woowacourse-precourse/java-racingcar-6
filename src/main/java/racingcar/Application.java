package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import racingcar.controller.RacingGameController;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        racingGame();
    }

    private static void racingGame() {
        String userInput = RacingGameView.inputCarName();
        int tryCount = RacingGameView.inputTryCount();

        HashMap<String, String> userCarNameAndMoveStatus = RacingGameController.userCarNameSave(userInput);

        for (int i = 0; i < tryCount; i++) {
            RacingGameController.referee(userCarNameAndMoveStatus);
            RacingGameView.moveStatus(userCarNameAndMoveStatus);
        }

        List<String> mostForwardCar = RacingGameController.mostMovingForwardCar(userCarNameAndMoveStatus);
        RacingGameView.winner(mostForwardCar);
    }
}
