package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
    public String readLine() {
        return Console.readLine();
    }

    public List<String> getStringListSplitByComma() {
        String input = this.readLine();
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int getOneNumber() {
        String input = this.readLine();
        return Integer.parseInt(input);
    }
}
