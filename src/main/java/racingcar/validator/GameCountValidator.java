package racingcar.validator;

public class GameCountValidator extends Validator {

    @Override
    public void validate(String gameCount) throws IllegalArgumentException {
        validateGameCountNotNumber(gameCount);

        validateGameCountOutOfRange(gameCount);

        validateGameCountStartWithZero(gameCount);
    }

    private void validateGameCountNotNumber(String gameCount) throws IllegalArgumentException {
        try {
            Integer.parseInt(gameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 실행 횟수는 숫자만 입력해야 합니다.");
        }
    }

    private void validateGameCountOutOfRange(String gameCount) throws IllegalArgumentException {
        int num = Integer.parseInt(gameCount);
        if (num <= 0) {
            throw new IllegalArgumentException("게임 실행 횟수는 양수만 입력해야 합니다.");
        }
    }

    private void validateGameCountStartWithZero(String gameCount) throws IllegalArgumentException {
        if (gameCount.startsWith("0")) {
            throw new IllegalArgumentException("게임 실행 횟수 입력은 0으로 시작하면 안됩니다.");
        }
    }
}
