package racingcar.validator;

public class GameCountValidator {

    private void validateIsEmpty(String gameCount) {
        if (gameCount.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }
}
