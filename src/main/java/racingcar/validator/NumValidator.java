package racingcar.validator;

public class NumValidator implements InputValidator {
    String input;

    public NumValidator(String input) {
        this.input = input;
    }

    @Override
    public void validate() {

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("지정 문자가 숫자타입이 아닙니다.");
        }
    }
}
