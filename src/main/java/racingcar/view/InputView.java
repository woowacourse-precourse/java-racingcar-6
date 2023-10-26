package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.StringEnum;

public class InputView {

    public String getParticipant() {
        System.out.println(StringEnum.PARTICIPANT_STRING);
        return Console.readLine();
    }

    public String getTryCount() {
        System.out.println(StringEnum.ROUND_STRING);
        return Console.readLine();
    }
}
