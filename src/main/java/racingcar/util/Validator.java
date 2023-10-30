package racingcar.util;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public void names(List<String> nameList) {
        size(nameList);
        blank(nameList);
        duplicate(nameList);
    }

    private void size(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
            }
        }
    }

    private void blank(List<String> nameList) {
        for (String name : nameList) {
            if (name.equals("")) {
                throw new IllegalArgumentException("이름에 공백이나 ,은 불가합니다.");
            }
        }
    }

    private void duplicate(List<String> nameList) {
        HashSet<String> nonDuplicate = new HashSet<>(nameList);
        if (nonDuplicate.size() != nameList.size()) {
            throw new IllegalArgumentException("중복된 이름은 불가합니다.");
        }
    }


    private void blank(String trial) {
        if (trial.equals("")) {
            throw new IllegalArgumentException("양의 정수를 입력하십시오.");
        }
    }

    private void positive(String trial) {
        for (int i = 0; i < trial.length(); i++) {
            if (notNum(trial.charAt(i), i)) {
                throw new IllegalArgumentException("양의 정수를 입력하십시오.");
            }
        }
    }

    private boolean notNum(char c, int index) {
        if (index == 0) {
            if (c >= '1' && c <= '9') {
                return false;
            }
            return true;
        }
        if (c >= '0' && c <= '9') {
            return false;
        }
        return true;
    }

}
