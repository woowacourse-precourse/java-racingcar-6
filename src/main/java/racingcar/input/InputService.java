package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    public static  String writeCarName() {
        return Console.readLine();
    }

    public static int attemptCount() {
        return Integer.parseInt(Console.readLine());
    }
}
