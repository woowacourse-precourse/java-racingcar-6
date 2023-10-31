package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputNumOfAttempts {
    public static int getNumOfAttempts() {
        System.out.println("시도할 회수는 몇 회인가요?");

        try {
            int numOfAttempts = Integer.parseInt(readLine());
            validateNumOfAttempts(numOfAttempts);

            return numOfAttempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateNumOfAttempts(int numOfAttempts) {
        if (numOfAttempts <= 0) {
            throw new IllegalArgumentException("잘못된 시도 회수 입력입니다.");
        }

    }
}
