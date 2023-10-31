package racingcar;

public class InputValidator {
    public void setRacingCars(String input) {
        if (!isRightRacingCarsComma(input)) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }
    private boolean isRightRacingCarsComma(String input) {
        if (input == "")
            return false;
        if (input.charAt(0) == ',')
            return false;
        if (input.charAt(input.length()-1) == ',')
            return false;

        for (int i = 0 ; i < input.length()-1 ; i++) {
            if (input.charAt(i) == ',' && input.charAt(i+1) == ',') {
                return false;
            }
        }

        return true;
    }
}
