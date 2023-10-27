package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> readCarName() {
        System.out.println(MessageConstraints.START_MESSAGE.getValue());
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
}
