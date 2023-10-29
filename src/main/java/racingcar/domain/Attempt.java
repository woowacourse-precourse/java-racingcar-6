package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Attempt {
    public int attemptNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount = Console.readLine();

        return validateInputNumber(inputCount);
    }

    public int validateInputNumber(String inputCount) {
        int countNum = checkInt(inputCount);
        checkNatural(countNum);

        return countNum;
    }

    public int checkInt(String inputCount) {
        try {
            return Integer.parseInt(inputCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다. 숫자를 입력해주세요.");
        }
    }

    public int checkNatural(int countNum) {
        if(countNum < 1)
            throw new IllegalArgumentException("1이상의 수를 입력해주세요.");

        return countNum;
    }
}