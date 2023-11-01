package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceCountTest {

    @Test
    @DisplayName("시도 횟수가 조건에 맞다면, 예외를 발생시키지 않는다.")
    void validateCounts_dontThrowException() {
        /**
         * given : 사용자 입력이 주어진다.
         * when : 정상적인 사용자 입력을 입력한다면,
         * then : 예외를 발생시키지 않는다.
         */
        String playerInput = "5";

        assertThatCode(() -> new RaceCount(playerInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 공백이라면, 예외를 발생시킨다.")
    void validateCounts_ThrowException_ifBlank() {
        /**
         * given : 사용자 입력이 주어진다.
         * when : 시도 횟수가 공백이라면,
         * then : IllegalArgumentException 예외를 발생시킨다.
         */
        String playerInput = " ";

        assertThatThrownBy(() -> new RaceCount(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상의 정수여야 합니다. 자동차 경주 게임을 종료합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 0이라면, 예외를 발생시킨다.")
    void validateCounts_ThrowException_ifRaceCountZero() {
        /**
         * given : 사용자 입력이 주어진다.
         * when : 시도 횟수가 0이라면,
         * then : IllegalArgumentException 예외를 발생시킨다.
         */
        String playerInput = "0";

        assertThatThrownBy(() -> new RaceCount(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상의 정수여야 합니다. 자동차 경주 게임을 종료합니다.");
    }
}
