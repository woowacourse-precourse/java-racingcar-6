package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> enterCarsName() {
        String names = Console.readLine()
                .trim();
        return Arrays.stream(names.split(","))
                .toList();
    }
}
