package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static ArrayList<String> inputCarName() {
        String input = Console.readLine();
        return new ArrayList<>(List.of(input.split(",")));
    }
    public static Integer inputRacingCount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}