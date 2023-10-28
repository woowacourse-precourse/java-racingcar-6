package racingcar.util;

import java.util.List;

public class Validator {

    public void isRightCarNameInput(List<String> splitedName) {
        isNoName(splitedName);
        checkLengthEachName(splitedName);
    }

    private void checkLengthEachName(List<String> splitedName) {
        for (String carName : splitedName) {
            if (isRightRangeCarName(carName)) {
                continue;
            }
            throw new IllegalArgumentException("자동차 이름의 길이는 0 이상 5이하이여야 합니다.");
        }
    }

    private void isNoName(List<String> splitedName) {
        if (splitedName.isEmpty()) {
            throw new IllegalArgumentException(
                "자동차 이름을 넣어주셔야 합니다! (이름1, 이름2, 이름3) 과 같은 형태로 넣어주셔야합니다!");
        }
    }

    private boolean isRightRangeCarName(String carName) {
        return !carName.isEmpty() && carName.length() <= 5;
    }

    public void isRightInputGameCount(String carGameCount) {
        try {
            Integer.parseInt(carGameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수는 숫자가 와야 합니다!");
        }
    }
}
