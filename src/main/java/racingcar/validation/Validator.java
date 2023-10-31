package racingcar.validation;

public class Validator {

    public void validCarName(String carName) {
        checkCarNameLength(carName);
    }

    public int validCount(String count) {
        return checkCountType(count);
    }

    private int checkCountType(String count) {
        Integer number;
        try {
            number = Integer.parseInt(count);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요", e);
        }
        return number;
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 해주세요.");
        }
    }
}
