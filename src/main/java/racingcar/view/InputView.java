package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static ArrayList inputCarName() {
        String input = Console.readLine();
        return new ArrayList<>(List.of(input.split(",")));
    }
}