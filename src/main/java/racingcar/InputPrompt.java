package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputPrompt {

    public List<CarName> readCarNames() {
        String rawInput = Console.readLine();
        String[] tokens = rawInput.split(",");
        List<CarName> result = new ArrayList<>();
        for (String name: tokens) {
            result.add(new CarName(name));
        }
        return result;
    }
}
