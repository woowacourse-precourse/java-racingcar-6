package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CountInput {

    static private int count;

    static String getCountInput() { // 회차 입력 받는 메서드
        String input = Console.readLine();
        Console.close();
        return input;
    }

    static void checkCountInput(String input) throws IllegalArgumentException { // 입력값을 검사하는 메서드
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if (count < 0 | count != (int)count) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

}
