package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다");
        }
    }
}
