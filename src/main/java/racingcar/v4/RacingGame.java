package racingcar.v4;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
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

}
