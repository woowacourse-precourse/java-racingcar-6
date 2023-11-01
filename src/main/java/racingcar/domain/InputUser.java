package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUser {
    ValidateRound validateRound = new ValidateRound();
    public int inputMove() {
        String howtry;
        System.out.println("시도할 회수는 몇회인가요?");
        howtry = Console.readLine();
        validateRound.validateRound(howtry);
        int number = Integer.parseInt(howtry);
        return number;
    }
}
