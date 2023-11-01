package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CountInput {

    static private int count;

    static String getCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return input;
    }

    static void checkCountInput(String input) throws IllegalArgumentException {
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if (count < 0 | count != (int)count) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

    public static int getCount() {
        return count;
    }
}
