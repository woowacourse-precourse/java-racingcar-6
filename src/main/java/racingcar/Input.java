package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    public static List<String> readCars() {
        String[] input = Validation.throwIfCarInputIsInvalid(Console.readLine());
        return Arrays.asList(input);
    }

    public static int readCount() {
        return Validation.throwIfCountInputIsInvalid(Console.readLine());
    }
}
