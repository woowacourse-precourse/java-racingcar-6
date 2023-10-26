package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
    public List<String> getCarNames() {
        String input = Console.readLine();
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int getGameCount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
