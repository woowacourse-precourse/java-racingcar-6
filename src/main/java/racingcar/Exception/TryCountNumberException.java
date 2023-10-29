package racingcar.Exception;

public class TryCountNumberException {
    public void validateTryCountInput(String tryCountNumInput) throws IllegalArgumentException {
        checkTryCountInputIsEmpty(tryCountNumInput);
        checkTryCountIsCharacter(tryCountNumInput);
    }

    private void checkTryCountInputIsEmpty(String tryCountNumInput) {
        if (tryCountNumInput.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void checkTryCountIsCharacter(String tryCountNumInput) {
        if (!IntegerTypeInput(tryCountNumInput)) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    private boolean IntegerTypeInput(String tryCountNumInput) {
        try {
            Integer.parseInt(tryCountNumInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
