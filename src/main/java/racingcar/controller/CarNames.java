package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class CarNames {
    private static final int NAME_LENGTH = 5;

    public static List<String> splitName() {
        String inputName = InputView.inputName();
        List<String> names = Arrays.asList(inputName.split(","));
        checkNames(names);
        return names;
    }

    private static void checkNames(List<String> names) {
        checkNamesLength(names);
        checkNamesSize(names);
    }

    private static void checkNamesLength(List<String> names) {
        if (names.stream().anyMatch(
                name -> name.length() > NAME_LENGTH || name.isEmpty())
        )
        {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    private static void checkNamesSize(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }
}
