package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.InputVerifier;

public class InputManager {
    public String readLine() {
        return Console.readLine();
    }

    public List<String> getStringListSplitByComma() {
        String input = this.readLine();
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int getOnePositiveNumber() {
        String input = this.readLine();
        if (!InputVerifier.isPositiveInteger(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    public boolean hasDuplicate(List<String> carNames) {
        return carNames.stream().distinct().count() != carNames.size();
    }
}
