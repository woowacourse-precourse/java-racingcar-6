package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static final String SEPARATOR = ",";
    private static final int MIN_CAR_NAME_LEN = 1;
    private static final int MAX_CAR_NAME_LEN = 5;

    public List<String> carNames() {
        String carNamesWithSeparator = Console.readLine();
        String[] tokens = StringManipulator.splitSeparator(carNamesWithSeparator, SEPARATOR);
        isValidCarNames(tokens);
        List<String> carNamesWithoutSeparator = StringManipulator.toList(tokens);
        return carNamesWithoutSeparator;
    }

    public int tryNumber() {
        String trialNum = Console.readLine();
        return Integer.parseInt(trialNum);
    }

    private void isValidCarNames(String[] carNameGroup) {
        for (String s : carNameGroup) {
            if (s.length() < MIN_CAR_NAME_LEN || s.length() > MAX_CAR_NAME_LEN) {
                throw new IllegalArgumentException("자동차 이름의 길이는 " + MIN_CAR_NAME_LEN + "이상, " + MAX_CAR_NAME_LEN + "이하여야 합니다.");
            }
        }
    }
}
