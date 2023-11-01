package racingcar.domain;

import java.util.List;

public class ErrorCheck {

    public void carNameCheck(List<String> cars) {
        for (String car : cars) {
            biggerThanFive(car);
        }
    }

    public void isNoValue(String cars) {
        if (cars == null || cars.isBlank()) {
            throw new IllegalArgumentException("공백만 입력할 수 없습니다.");
        }
    }

    public void biggerThanFive(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("5자 이하의 자동차 이름을 콤마로 구분하여 입력해주세요.");
        }
    }

    public void inputNumberCheck(String userInput) {
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException("올바른 정수를 입력해 주세요");
        }
        if (Integer.parseInt(userInput) < 0) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }


    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
