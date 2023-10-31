package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("우승자 일급 컬렉션의 객체에")
class WinnersTest {

    @Test
    @DisplayName("생성 요청시 우승자가 없는 경우 예외를 던지는가")
    void createValidation() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Winners(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("결과 메시지 요청시")
    class ToResultMessage {

        @Test
        @DisplayName("우승자가 단일인 경우 기본 메시지와 함께 이름을 반환하는가")
        void onlyOneWinner() {
            // given
            final String defaultMessage = "최종 우승자 : ";
            final String winnerName = "win";
            final Winners winners = new Winners(List.of(winnerName));

            // when
            final String result = winners.toResultMessage();

            // then
            assertThat(result).contains(winnerName, defaultMessage);
        }

        @Test
        @DisplayName("우승자가 여러명인 경우 기본 메시지와 함께 ', '로 이름을 구분해 반환하는가")
        void multipleWinners() {
            // given
            final String defaultMessage = "최종 우승자 : ";
            final String delimiter = ", ";
            final String firstWinnerName = "win";
            final String secondWinnerName = "ner";
            final Winners winners = new Winners(List.of(firstWinnerName, secondWinnerName));

            // when
            final String result = winners.toResultMessage();

            // then
            assertThat(result)
                    .contains(firstWinnerName, secondWinnerName, defaultMessage, delimiter);
        }
    }
}
