package racingcar.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PlayNumberInput {
    public static int playNumber() {
        String num = readLine();
        catchException(num);
        return Integer.parseInt(num);
    }

    public static void catchException(String num) {
        notNumberException(num);
    }


    public static void notNumberException(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
