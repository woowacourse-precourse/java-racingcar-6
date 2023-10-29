package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUser {
    public int inputMove() {
        String howtry;
        System.out.println("시도할 회수는 몇회인가요?");
        howtry = Console.readLine();
        int number = Integer.parseInt(howtry);
        return number;
    }
}
