package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

public class TryInput {
    public int getTryCount() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                int tryCount = Integer.parseInt(Console.readLine());

                if (tryCount >= 1) {
                    return tryCount;
                } else {
                    throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다. 다시 입력하세요.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
            }
        }
    }
}
