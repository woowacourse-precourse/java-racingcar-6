package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

public class TryInput {
    public int getTryCount(String number) {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                int tryCount = Integer.parseInt(Console.readLine());
                if (tryCount >= 1) {
                    return tryCount;
                } else {
                    System.out.println("시도 횟수는 1 이상의 숫자여야 합니다. 다시 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력하세요.");
            }
        }
    }
}
