package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String[] inputCarNames() {
        Message.printInputCarNameMessage();
        String carNames = Console.readLine();
        String[] carNameArray = carNames.split(",");
        validateCarName(carNameArray);
        return carNameArray;
    }

    private void validateCarName(String[] carNameArray) {
        for (String carName : carNameArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public int inputTryCount() {
        Message.printInputTryCountMessage();
        int tryCount = Integer.parseInt(Console.readLine());
        validateTryCount(tryCount);
        return tryCount;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
        }
    }
}
