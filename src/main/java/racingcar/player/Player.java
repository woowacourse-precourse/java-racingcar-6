package racingcar.player;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Message;

public class Player {
    public int inputMoveCnt() {
        final String MOVE_CNT_REGEX = "[0-9]+";
        System.out.println(Message.INPUT_MOVE_COUNT);
        String num = Console.readLine();
        if (!num.matches(MOVE_CNT_REGEX)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(num);
    }
}
