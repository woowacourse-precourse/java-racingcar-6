package racingcar;

public class InputValidator {
    public void setRacingCars(String input) {
        if (!isRightRacingCarsComma(input)) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
        if (!isRightRacingCarsNameLength(input)) {
            throw new IllegalArgumentException("이름이 5자 초과인 자동차가 존재합니다.");
        }
    }

    private boolean isRightRacingCarsComma(String input) {
        if (input == "") {
            return false;
        }
        if (input.charAt(0) == ',') {
            return false;
        }
        if (input.charAt(input.length() - 1) == ',') {
            return false;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == ',' && input.charAt(i + 1) == ',') {
                return false;
            }
        }

        return true;
    }

    private boolean isRightRacingCarsNameLength(String input) {
        String[] split = input.split(",");
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 5) {
                return false;
            }
        }

        return true;
    }
}
