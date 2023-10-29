package racingcar.domain.racingGame.validator;

import racingcar.domain.racingGame.TryCountManager;
import racingcar.domain.utils.NumberUtils;

public class TryCountValidator {

    public void validateTryCount(String input) {
        validateIsNumeric(input);
        validateMaxTryCount(input);
    }

    private void validateIsNumeric(String input) {
        if(!NumberUtils.isNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validateMaxTryCount(String input) {
        if(Integer.parseInt(input) > TryCountManager.MAX_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 최대 " + TryCountManager.MAX_TRY_COUNT + "번 가능합니다.");
        }
    }
}
