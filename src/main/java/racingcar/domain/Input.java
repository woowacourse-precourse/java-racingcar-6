package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    public static List<String> readCarName() {
        String input = Console.readLine();
        String[] Names = input.split(",");
        return Arrays.asList(Names);
    }
}
