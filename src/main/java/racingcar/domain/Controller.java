package racingcar.domain;

import static racingcar.view.OutputView.createStringBuilders;
import static racingcar.view.OutputView.displayResult;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.Validator;

public class Controller {
    private static final List<String> carNameList = Car.getCarName();
    static List<StringBuilder> result = createStringBuilders(carNameList);
    static List<StringBuilder> resultsb = displayResult(result);

    public static void validateCarNames() {
        if (!Validator.isCarNameOverFiveCharacters(carNameList)) {
            throw new IllegalArgumentException();
        }

        if (!Validator.validateDelimiter(carNameList)) {
            throw new IllegalArgumentException();
        }

        if (!Validator.isEmpty(carNameList)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputAttemptsCount(String inputAttemptsCount) {
        if (!Validator.isNonNumericInput(inputAttemptsCount)) {
            throw new IllegalArgumentException();
        }

        if (!Validator.isEmpty(Collections.singletonList(inputAttemptsCount))) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean makeMoveDecision() {
        boolean move = false;
        int moveDecision = Randoms.pickNumberInRange(0, 9);
        if (moveDecision >= 4) {
            move = true;
        }
        return move;
    }

    public static void playRace(String inputAttemptsCount) {
        int raceCount = Integer.parseInt(inputAttemptsCount);
        for (int i = 0; i < raceCount; i++) {
            displayResult(result);
            System.out.println();
        }
    }

    public static int winnerDashCount() {
        int winnerDashCount = 0;
        for (int i = 0; i < resultsb.size(); i++) {
            String carInfo = String.valueOf(resultsb.get(i));
            int dashCount = countChar(carInfo, '-');
            if (dashCount >= winnerDashCount) {
                winnerDashCount = dashCount;
            }
        }
        return winnerDashCount;
    }

    private static int countChar(String carInfo, char c) {
        int count = 0;

        for (int i = 0; i < carInfo.length(); i++) {
            if (carInfo.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }

    public static List<String> getgameWinner() {
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < resultsb.size(); i++) {
            String carInfo = String.valueOf(resultsb.get(i));
            int dashCount = countChar(carInfo, '-');
            if (dashCount == winnerDashCount()) {
                winnerList.add(carInfo.substring(0, carInfo.indexOf(" ")));
            }
        }
        return winnerList;
    }
}

