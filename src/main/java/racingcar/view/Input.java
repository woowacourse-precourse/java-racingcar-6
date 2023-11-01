package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String readLine() {
        return Console.readLine();
    }

    public static Integer readInteger() {
        try {
            String readLine = Console.readLine();
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해야 합니다.");
        }
    }
}
