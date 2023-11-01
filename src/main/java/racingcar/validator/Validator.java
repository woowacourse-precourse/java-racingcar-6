package racingcar.validator;

import java.util.List;

public class Validator {

    public void validateCar(List<String> names) {
        isDuplicated(names);
        isGreaterThanOne(names);
        names.forEach(name -> {
            isUnderFive(name);
            isBlank(name);
        });
    }

    public int validateCount(String count) {
        return isPositive(isInteger(count));
    }

    private void isUnderFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 5자 초과입니다.");
        }
    }

    private void isDuplicated(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("이름이 중복되었습니다.");
        }
    }

    private void isBlank(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 공백입니다.");
        }
    }

    private void isGreaterThanOne(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("차가 한 개입니다.");
        }
    }

    private int isPositive(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("회차는 1 이상이어야 합니다.");
        }
        return count;
    }

    private int isInteger(String count) {
        int result;
        try {
            result = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수여야 합니다.");
        }
        return result;
    }
}
