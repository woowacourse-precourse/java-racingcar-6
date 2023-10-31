package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private void checkNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
    }

    private void checkNotEndsWithComma(String userInput){
        if(userInput.endsWith(",")){
            throw new IllegalArgumentException("마지막이 쉼표로 끝납니다.");
        }
    }
}
