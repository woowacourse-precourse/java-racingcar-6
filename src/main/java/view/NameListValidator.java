package view;

import java.util.HashSet;
import java.util.List;

public class NameListValidator {
    private void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
    }

    private void validateNotEndsWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("마지막이 쉼표로 끝납니다.");
        }
    }

    private void validateContainsRepeatingCommas(String input) {
        String inputWithoutSpace = ignoreSpace(input);
        for (int i = 0; i < inputWithoutSpace.length() - 1; i++) {
            if (inputWithoutSpace.charAt(i) == ',' && inputWithoutSpace.charAt(i + 1) == ',') {
                throw new IllegalArgumentException("쉼표 사이에 값이 없습니다.");
            }
        }
    }

    private String ignoreSpace(String input) {
        return input.replace(" ", "");
    }

    private void validateNameLength(List<String> names, int maxLength) {
        for (String name : names) {
            if (name.length() > maxLength) {
                String message = "이름의 길이가 " + maxLength + "자가 넘습니다.";
                throw new IllegalArgumentException(message);
            }
        }
    }

    private void validateNameDuplication(List<String> names){
        HashSet<String> nameSet = new HashSet<>();
        for(String name : names){
            if(!nameSet.add(name)){
                throw new IllegalArgumentException("중복되는 이름이 있습니다.");
            }
        }
    }
}
