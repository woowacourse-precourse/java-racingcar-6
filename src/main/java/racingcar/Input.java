package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    public static List<String> carNames() {
        String namesInput = Console.readLine();
        List<String> nameList = List.of(namesInput.split(","));

        return nameList;
    }

    public static int round() {
        return Integer.parseInt(Console.readLine());
    }
}
