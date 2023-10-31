package racingcar.util;

import racingcar.view.InputView;

public class UserInput {
    static final int NAME_LENGTH = 5;

    public static String[] getCarNames() {
        String[] carNames = InputView.setUserInput().split(",");
        checkNameLength(carNames);
        return carNames;
    }

    public static void checkNameLength(String[] nameList) {
        for (String name : nameList) {
            if (name.length() > NAME_LENGTH) {
                throw new IllegalArgumentException(String.format("자동차의 이름을 %s자 이내로 입력해주세요.", NAME_LENGTH));
            }
        }
    }
}
