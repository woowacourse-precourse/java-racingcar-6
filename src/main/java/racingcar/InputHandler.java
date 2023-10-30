package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Constants.*;

public class InputHandler {
    public List<String> carNames() {
        String carNamesWithSeparator = Console.readLine();
        String[] tokens = StringManipulator.splitSeparator(carNamesWithSeparator, SEPARATOR);
        isValidCarNames(tokens);
        List<String> carNamesWithoutSeparator = StringManipulator.toList(tokens);
        return carNamesWithoutSeparator;
    }

    public int tryNumber() {
        String trialNum = Console.readLine();
        isValidTryNumber(trialNum);
        return Integer.parseInt(trialNum);
    }

    private void isValidCarNames(String[] carNameGroup) {
        for (String s : carNameGroup) {
            if (s.length() < MIN_CAR_NAME_LEN || s.length() > MAX_CAR_NAME_LEN) {
                throw new IllegalArgumentException("자동차 이름의 길이는 " + MIN_CAR_NAME_LEN + "이상, " + MAX_CAR_NAME_LEN + "이하여야 합니다.");
            }
        }
    }

    private void isValidTryNumber(String trialNum) {
        if (!trialNum.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("시도 횟수는 1이상의 숫자만 입력해야 합니다.");
        }
    }
}
