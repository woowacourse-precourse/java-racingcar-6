package racingcar.vo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrialCountTest {

    public static final Integer MIN_TRIAL = 1;
    public static final String SMALLER_THAN_MIN_NUMBER_MSG = MIN_TRIAL + " 이상의 정수값만 입력할 수 있습니다.";

    @DisplayName("시도 횟수가 유효한 경우 객체를 생성할 수 있다.")
    @Test
    void validTrialCount_test() {
        // given
        Integer validCount = MIN_TRIAL;

        // when
        TrialCount trialCount = assertDoesNotThrow(() -> {
            return new TrialCount(validCount);
        });

        // then
        assertEquals(validCount, trialCount.number());
    }

    @DisplayName("시도 횟수가 유효하지 않은 경우 객체가 생성되지 않고 예외가 발생한다.")
    @Test
    void invalidTrialCount_test() {
        Integer invalidCount = MIN_TRIAL - 1;

        try {
            TrialCount trialCount = new TrialCount(invalidCount);
        } catch (IllegalArgumentException e) {
            assertEquals(SMALLER_THAN_MIN_NUMBER_MSG, e.getMessage());
        }
    }
}