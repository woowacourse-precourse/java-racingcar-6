package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.GameConstants;
import racingcar.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.GameConstants.*;
import static racingcar.constant.GameConstants.COLONS;
import static racingcar.constant.GameConstants.SPACE;

public class CarRaceGameView {
    private CarRaceGameView() {};
    public static String startGameView() {
        System.out.println(START_GAME);
        String carNames = readLine();
        Validator.carNamesComma(carNames);


        return carNames;
    }

    public static String attemptNumberView() {
        System.out.println(ATTEMPT_NUMBER);
        String attemptNumberString = readLine();
        Validator.isNull(attemptNumberString);
        Validator.isNumber(attemptNumberString);
        Validator.attemptNumberRange(attemptNumberString);

        return attemptNumberString;
    }

    public static void tryForwardResultView(String carName, int advanceNumber) {
        String advanceString = "";
        for (int i = 0; i < advanceNumber; i++) {
            advanceString += "-";
        }
        System.out.println(carName + SPACE + COLONS + SPACE + advanceString);

    }

    public static void LineBreakView() {
        System.out.println(NULL);
    }

    public static void gameResultView(List<String> winnerList) {
        String resultText = FINAL_WINNER + SPACE + COLONS + SPACE;
        String winnerListString = winnerList.stream().collect(Collectors.joining(","));
        System.out.println(resultText + winnerListString);
    }

}
