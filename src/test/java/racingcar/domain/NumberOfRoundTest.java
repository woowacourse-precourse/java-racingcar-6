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
        Assertions.assertThat(numberOfRound.getCurrentRound()).isEqualTo(0);
        Assertions.assertThat(numberOfRound.getTotalRounds()).isEqualTo(value);
    }

    @DisplayName("시도 횟수가 음수이면 예외가 발생한다.")
    @Test
    void createNumberOfRoundExceptionTestByZero() {
        // given
        int value = -1;

        // when & then
        Assertions.assertThatThrownBy(() -> new NumberOfRound(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 초과의 숫자만 입력 가능합니다.");
    }

    @DisplayName("남은 시도 횟수가 없을 경우 hasRoundsLeft()는 false를 반환한다.")
    @Test
    void hasRoundsLeftFalseTest() {
        // given
        int totalRound = 1;
        NumberOfRound numberOfRound = new NumberOfRound(totalRound);

        // when
        numberOfRound.nextRound();

        // then
        Assertions.assertThat(numberOfRound.isLastRound()).isTrue();
    }
}
