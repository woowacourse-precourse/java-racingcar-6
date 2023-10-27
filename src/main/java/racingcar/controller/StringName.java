package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class StringName {
    private static final int NAME_LENGTH = 5;

    public static List<String> splitName() {
        String inputName = InputView.inputName();
        List<String> names = Arrays.asList(inputName.split(","));
        validateNames(names);
        return names;
    }

    private static void validateNames(List<String> names) {
        boolean validName = names.stream()
                .allMatch(name -> name.length() <= NAME_LENGTH);
        if (!validName) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

}
