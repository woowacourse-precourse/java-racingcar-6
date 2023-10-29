package racingcar.Exception;

public class TryCountNumberException {
    public void validateTryCountInput(String tryCountNumInput) throws IllegalArgumentException {
        checkTryCountInputIsEmpty(tryCountNumInput);
    }
    private void checkTryCountInputIsEmpty(String tryCountNumInput) {
        if (tryCountNumInput.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }
}
