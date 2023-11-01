package racingcar.validator;

public class GameCountInputValidator implements BasicValidator<String> {
    @Override
    public void validate(String Input) {
        isInputEmpty(Input);
        isInputInteger(Input);
        isInputPositive(Input);
    }
    private void isInputEmpty(String Input) {
        if (Input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
    }

    private void isInputPositive(String Input) {
        if (Integer.parseInt(Input) <= 0) {
            throw new IllegalArgumentException("입력값이 0 이하의 숫자입니다.");
        }
    }

    private void isInputInteger(String Input) {
        try {
            Integer.parseInt(Input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }
}
