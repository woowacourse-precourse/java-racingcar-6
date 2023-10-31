package racingcar.view;

import java.util.List;
import racingcar.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.GameConstants.*;
import static racingcar.constant.GameConstants.COLONS;
import static racingcar.constant.GameConstants.SPACE;

public class CarRaceGameView {
    private CarRaceGameView() {}
    public static void printStartGame() {
        System.out.println(START_GAME);
    }

    public static String getInput() {
        return readLine();
    }

    public static void printAttemptNumber() {
        System.out.println(ATTEMPT_NUMBER);
    }

    public static void printOneRoundResult(String carName, int advanceNumber) {
        String advanceString = NULL;
        for (int i = 0; i < advanceNumber; i++) {
            advanceString += DASH;
        }
        System.out.println(carName + SPACE + COLONS + SPACE + advanceString);

    }

    public static void printBlackLine() {
        System.out.println(NULL);
    }

    public static void printGameResult(List<String> winnerList) {
        String resultText = FINAL_WINNER + SPACE + COLONS + SPACE;
        String winnerListString = String.join(COMMA+SPACE, winnerList);
        System.out.println(resultText + winnerListString);
    }

}

