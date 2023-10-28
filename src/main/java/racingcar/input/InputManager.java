package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputManager {

    public List<String> inputNames() {
        final String names = Console.readLine();
        final List<String> nameList = Arrays
                .stream(names.split(","))
                .toList();
        validateNames(nameList);
        return nameList;
    }

    private void validateNames(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
