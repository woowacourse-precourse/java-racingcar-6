package racingcar;

public class Exception {

    public void isCarNameValid(String name) {
        isNameNull(name);
        isNameInRange(name);
    }

    public void isTryCountValid(String count) {
        isInteger(count);
        isGreaterThanZero(count);
    }

    private void isNameNull(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력해 주세요.");
        }
    }

    private void isNameInRange(String name) {
        if (name.length() > MagicNumber.CAR_NAME_LENGTH_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 작성해 주세요.");
        }
    }

    private void isInteger(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수를 입력해 주세요.");
        }
    }

    private void isGreaterThanZero(String count) {
        if (count.compareTo("0") == 1) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 정수를 입력해 주세요.");
        }
    }
}
