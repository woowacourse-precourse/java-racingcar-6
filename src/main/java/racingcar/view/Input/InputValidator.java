package racingcar.view.Input;

public class InputValidator {
    private final String NUMBER_REGX = "^[0-9]+$";

        // [x] 쉼표가 연속해서 있을 경우 >> 정규 표현식 split(",+")
        // [x] 쉼표 사이에 공백이 있을 경우 >> replace(" ", "");
        // [x] 공백일 경우 >> exception

    public void isNull(String input) {
        if (input.trim().length() == 0) {
            throw new IllegalArgumentException("");
        }
    }

    public void isNumberOnly(String number) {
        if (!number.matches(NUMBER_REGX)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
    public void isPositiveOnly(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("1회 부터 입력 가능 합니다.");
        }
    }
}
