package racingcar.domain.reception;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.exception.Checker;

import java.util.HashMap;

public class ReceptionDesk {

    public static HashMap<String, Integer> registering(String[] lineUpArr) {
        HashMap<String, Integer> lineUp = new HashMap<>();

        for (String carName : lineUpArr) {
            lineUp.put(carName, 0);
        }

        return lineUp;
    }
}
