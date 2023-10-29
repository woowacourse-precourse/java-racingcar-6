package racingcar.domain.reception;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.exception.Checker;

import java.util.HashMap;

public class ReceptionDesk {

    public static HashMap<String, Integer> registering() {
        HashMap<String, Integer> lineUp = new HashMap<>();
        String[] lineUpArr = Console.readLine().split(",");

        Checker.lenCheck(lineUpArr);

        for (String carName : lineUpArr) {
            lineUp.put(carName, 0);
        }

        return lineUp;
    }
}
