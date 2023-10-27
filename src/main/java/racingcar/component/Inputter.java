package racingcar.component;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Inputter {
    private Inputter() {}
    private static Inputter inputter;

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

    public List<String> getNameInput() {
        String input = Console.readLine();
        return Arrays.stream(input.split(",")).toList();
    }
}
