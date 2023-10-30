package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputView {

    public static List<String> carName() {
        String input = Console.readLine();

        List<String> carNameList = Arrays.asList(input.split(","));

        return carNameList;
    }

    public static int attempt() {
        String input = Console.readLine();

        int attempt = Integer.parseInt(input);

        return attempt;
    }

}
