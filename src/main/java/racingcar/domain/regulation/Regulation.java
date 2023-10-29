package racingcar.domain.regulation;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

import static racingcar.domain.exception.Checker.typeCheck;

public class Regulation {
    public static int setLaps() {
        return typeCheck(Console.readLine());
    }

    public static void goStop(HashMap<String, Integer> lineUp) {
        for (String carName : lineUp.keySet()) {

        }

        if (Randoms.pickNumberInRange(0, 9) > 3) {

        }
    }
}
