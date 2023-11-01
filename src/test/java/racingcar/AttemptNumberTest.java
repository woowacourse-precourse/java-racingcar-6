package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("시도횟수 테스트")
class AttemptNumberTest {

    @Test
    @DisplayName("숫자 스트링을 이용해 AttemptNumber 을 생성한다.")
    void createAttemptNumber() {
        assertThatCode(() -> new AttemptNumber("100"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("숫자 스트링이 아닐 경우 AttemptNumber 을 생성시 예외를 던진다.")
    void throwExceptionWhenNotStringNumber() {
        assertThatThrownBy(() -> new AttemptNumber("213uu"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("only number please");
    }

    @Test
    @DisplayName("Null 이 올 경우 AttemptNumber 을 생성시 예외를 던진다.")
    void throwExceptionWhenNull() {
        assertThatThrownBy(() -> new AttemptNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("please input attempt game number");
    }
}