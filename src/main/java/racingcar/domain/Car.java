package racingcar.domain;

import java.util.*;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        checkCarNameValidation(name);
        this.name = name;
        this.position = 0;
    }

    public void movePosition() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void checkCarNameValidation(String name) {
        checkCarNameCharacterCount(name);
        checkCarNameRegex(name);
    }

    public void checkCarNameCharacterCount(String name) {
        if (name.isEmpty() || name.length() > 6) {
            throw new IllegalArgumentException("자동차 이름 글자수는 1~5자 사이로 입력해야합니다.");
        }
    }

    public void checkCarNameRegex(String name) {
        String pattern = "^[가-힣A-Za-z0-9]*$";

        if (!name.matches(pattern)) {
            throw new IllegalArgumentException("사용할 수 없는 자동차 이름이 존재합니다.");
        }
    }

}
