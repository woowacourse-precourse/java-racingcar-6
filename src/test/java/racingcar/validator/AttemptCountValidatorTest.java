package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.AttemptCount;

public class AttemptCountValidatorTest {
    @DisplayName("콘솔로 입력된 시도횟수의 validate 판단 및 정수로 변환해서 반환해주는 기능")
    @Test
    void inputAttemptCount_횟수_입력() {
        String input = "12345";
        assertThat(new AttemptCount(input).getAttemptCount()).isEqualTo(12345);
    }

    @DisplayName("입력 문자열이 정수로 이루어져 있는지 확인하는 기능.")
    @Test
    void inputAttemptCount_예외처리() {
        String input = "1234a5";

        assertThatThrownBy(() -> new AttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
