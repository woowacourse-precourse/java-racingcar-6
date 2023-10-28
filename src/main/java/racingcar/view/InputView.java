package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.GameConstant;

public class InputView {

    public static String getCarNames() {
        String carNames = Console.readLine();
        return carNames;
    }

    public static Integer getTrialNumber() {
        String trialString = Console.readLine();

        isNumber(trialString);
        isZero(trialString);

        Integer trialNumber = Integer.parseInt(trialString);
        return trialNumber;
    }

    private static void isNumber(String trialString) {
        if (!trialString.matches(GameConstant.NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void isZero(String trialString) {
        if (trialString.matches(GameConstant.ZERO_REGEX)) {
            throw new IllegalArgumentException("1이상의 숫자를 입력해주세요.");
        }
    }
}