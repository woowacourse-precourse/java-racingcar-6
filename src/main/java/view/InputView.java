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

    private void checkContainsRepeatingCommas(String userInput) {
        String ignoreSpace = ignoreSpace(userInput);
        for (int i = 0; i < ignoreSpace.length() - 1; i++) {
            if (ignoreSpace.charAt(i) == ',' && ignoreSpace.charAt(i+1) == ',') {
                throw new IllegalArgumentException("쉼표 사이에 값이 없습니다.");
            }
        }
    }

    private String ignoreSpace(String userInput){
        return userInput.replace(" ", "");
    }
}
