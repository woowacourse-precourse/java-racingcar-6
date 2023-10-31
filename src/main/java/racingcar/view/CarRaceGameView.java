package racingcar.view;

import java.util.List;
import racingcar.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.GameConstants.*;
import static racingcar.constant.GameConstants.COLONS;
import static racingcar.constant.GameConstants.SPACE;

public class CarRaceGameView {
    private CarRaceGameView() {}
    public static String startGameView() {
        System.out.println(START_GAME);
        String carNames = readLine();
        Validator.checkCarNamesForm(carNames);

        return carNames;
    }

    public static String attemptNumberView() {
        System.out.println(ATTEMPT_NUMBER);
        String attemptNumberString = readLine();
        Validator.isEmptyString(attemptNumberString);
        Validator.isNumber(attemptNumberString);
        Validator.isMoreThanOne(attemptNumberString);

        return attemptNumberString;
    }

    public static void tryForwardResultView(String carName, int advanceNumber) {
        String advanceString = NULL;
        for (int i = 0; i < advanceNumber; i++) {
            advanceString += DASH;
        }
        System.out.println(carName + SPACE + COLONS + SPACE + advanceString);

    }

    public static void newRoundRefreshView() {
        System.out.println(NULL);
    }

    public static void gameResultView(List<String> winnerList) {
        String resultText = FINAL_WINNER + SPACE + COLONS + SPACE;
        String winnerListString = String.join(COMMA+SPACE, winnerList);
        System.out.println(resultText + winnerListString);
    }

}

