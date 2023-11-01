package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.global.InputVerifier;

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

    public boolean hasDuplicateInList(List<String> list) {
        return list.stream().distinct().count() != list.size();
    }

    public boolean isStringLengthValidInList(List<String> list, int length) {
        return list.stream().allMatch(s -> s.length() <= length);
    }

    public boolean isStringNumValidInList(List<String> list, int length) {
        return list.size() <= length;
    }
}
