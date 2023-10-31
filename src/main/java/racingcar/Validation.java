package racingcar;

import java.util.HashSet;
import java.util.List;

public class Validation {

    public boolean isNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("이름이 없는 자동차가 있습니다.");
            }
        }
        return true;
    }

    public boolean isNotRepeated(List<String> carNames) {
        HashSet<String> carSet = new HashSet<String>(carNames);
        if (carSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복되는 이름이 있습니다.");
        }
        return true;
    }

    public boolean isLessThanSix(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5글자 이하로 입력해주세요.");
            }
        }
        return true;
    }

    public boolean isValidName(List<String> carNames) {
        if (isNotEmpty(carNames) && isNotRepeated(carNames) && isLessThanSix(carNames)) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 이름을 입력했습니다.");
    }

    public boolean isValidNumber(String number) {
        try {
            long userInput = Long.parseLong(number);
            if (userInput < 0) {
                throw new IllegalArgumentException("양수를 입력해주세요.");
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }

        return true;
    }

}
