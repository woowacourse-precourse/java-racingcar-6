package racingcar.v2;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class CreateCarV2 {
    public String input() {
        return Console.readLine();
    }

    public String[] carName(String input) {
        String[] carName = input.split(",");
        return carName;
    }
}
