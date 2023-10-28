package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    public  String writeCarName() {
        return Console.readLine();
    }

    public int attemptCount() {
        return Integer.parseInt(Console.readLine());
    }
}
