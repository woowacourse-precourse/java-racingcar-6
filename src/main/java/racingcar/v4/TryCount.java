package racingcar.v4;

import camp.nextstep.edu.missionutils.Console;

public class TryCount {
    public String inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = Console.readLine();
        return inputTryCount;
    }

    public void validateTryCountNotEmpty(String inputTryCount) {
        if (inputTryCount == null || inputTryCount.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값입니다. 시도 횟수를 입력해 주세요.");
        }
    }

    public void validateTryCountIsNumber(String inputTryCount) {
        try {
            Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다. 시도 횟수를 입력해 주세요.");
        }
    }

    public void validateTryCountInRange(String inputTryCount) {
        int tryCount = Integer.parseInt(inputTryCount);
        if (tryCount < 1 || tryCount > 10) {
            throw new IllegalArgumentException("시도 횟수는 1이상 10이하로 입력해 주세요.");
        }
    }

}
