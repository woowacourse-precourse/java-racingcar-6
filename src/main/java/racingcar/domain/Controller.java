package racingcar.domain;

import static racingcar.view.InputView.inputAttemptsCount;
import static racingcar.view.OutputView.displayResult;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.Validator;

public class Controller {
    private static final List<String> carNameList = Car.getCarName();

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
            displayResult();
            System.out.println();
        }
    }
}
