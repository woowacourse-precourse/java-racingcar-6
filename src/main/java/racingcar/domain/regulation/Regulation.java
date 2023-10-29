package racingcar.domain.regulation;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

import static racingcar.domain.exception.Checker.typeCheck;

public class Regulation {
    public static int setLaps() {
        return typeCheck(Console.readLine());
    }

    public static void goStop(HashMap<String, Integer> lineUp) {
        for (Map.Entry<String, Integer> carRecord : lineUp.entrySet()) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                carRecord.setValue(carRecord.getValue() + 1);
            }
        }
    }
}
