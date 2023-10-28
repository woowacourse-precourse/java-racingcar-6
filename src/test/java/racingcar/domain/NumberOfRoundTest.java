package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOfRoundTest {

    @DisplayName("입력 받은 시도 횟수로 객체가 생성된다.")
    @Test
    void createNumberOfRoundSuccessTest() {
        // given
        int value = 5;

        // when
        NumberOfRound numberOfRound = new NumberOfRound(value);

        // then
        Assertions.assertThat(numberOfRound.value()).isEqualTo(value);
    }

    @DisplayName("시도 횟수가 음수이면 예외가 발생한다.")
    @Test
    void createNumberOfRoundExceptionTestByZero() {
        // given
        int value = -1;

        // when & then
        Assertions.assertThatThrownBy(() -> new NumberOfRound(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 이상의 숫자만 입력 가능합니다.");
    }

    @DisplayName("남은 시도 횟수가 없을 경우 hasRoundsLeft()는 false를 반환한다.")
    @Test
    void hasRoundsLeftFalseTest() {
        // given
        int currentRound = 1;
        NumberOfRound numberOfRound = new NumberOfRound(currentRound);

        // when
        NumberOfRound nextNumberOfRound = numberOfRound.consumeRound();

        // then
        Assertions.assertThat(nextNumberOfRound.value()).isEqualTo(currentRound - 1);
    }
}
