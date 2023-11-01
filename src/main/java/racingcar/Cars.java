package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Cars {

    private final int maxNameLength = 5;
    public List<String> name() {
        String inputNames = Console.readLine();
        List<String> names = List.of(inputNames.split(","));

        for (String number : names) {
            validNumber(number);
        }
        return names;
    }

    private void validNumber(String name) {
        if (name.length() > maxNameLength) {
            throw new IllegalArgumentException("이름의 길이나 너무 깁니다");
        }
    }
}
