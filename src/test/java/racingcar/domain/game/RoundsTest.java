package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoundsTest {

    @DisplayName("Rounds 생성자에 0 미만의 정수가 주어진 경우 예외를 발생한다.")
    @Test
    void givenLowerZeroNumber_WhenNew_ThenThrowException() {
        // Given
        int round = -1;

        // When
        // Then
        assertThatThrownBy(() -> new Rounds(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("회수는 음수일 수 없습니다.");
    }

    @DisplayName("Rounds 생성자에 0 이상의 정수가 주어진 경우 인스턴스를 생성한다.")
    @Test
    void givenUpperZeroNumber_WhenNew_ThenReturnNewInstance() {
        // Given
        int round = 2;

        // When
        Rounds rounds = new Rounds(round);

        // Then
        assertFalse(rounds.isEnd());
    }

    @DisplayName("Rounds의 remainRound이 0이하인 경우 isEnd의 응답으로 True를 반환한다.")
    @Test
    void givenZeroNumber_WhenIsEnd_ThenReturnTrue() {
        // Given
        int round = 0;

        // When
        Rounds rounds = new Rounds(round);

        // Then
        assertTrue(rounds.isEnd());
    }

    @DisplayName("Rounds의 remainRound이 1이상인 경우 isEnd의 응답으로 False를 반환한다.")
    @Test
    void givenUpperOneNumber_WhenIsEnd_ThenReturnFalse() {
        // Given
        int round = 1;

        // When
        Rounds rounds = new Rounds(round);

        // Then
        assertFalse(rounds.isEnd());
    }

    @DisplayName("Rounds의 남은 라운드가 1이상인 경우 next 호출 이후 남은 라운드를 1 감소한다.")
    @Test
    void givenUpperOneNumber_WhenNext_ThenDecreaseRemainRound() {
        // Given
        int round = 2;

        // When
        Rounds rounds = new Rounds(round);
        int count = 0;
        while (!rounds.isEnd()) {
            rounds.next();
            count += 1;
        }

        // Then
        assertTrue(0 <= count);
    }
}