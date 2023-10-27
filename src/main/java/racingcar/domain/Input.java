package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] getCars() {
        return Console.readLine().split(",");
    }

    public static int getTryCount() {
        String count = Console.readLine();
        if (Utils.isNaturalNumber(count)){
            return Integer.parseInt(count);
        }
        throw new IllegalArgumentException("시도할 회수는 자연수만 가능합니다.");
    }
}
