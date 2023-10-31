package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RoundTest {

    @DisplayName("hasRemainingRound() 테스트 : 라운드가 남아있다면 true를 반환, 남아있지 않다면 false를 반환한다.")
    @Test
    void hasRemainingRound() {
        Round round1 = new Round(new Count(1));
        Round round2 = new Round(new Count(0));

        boolean expectedTrue = round1.hasRemainingRound();
        boolean expectedFalse = round2.hasRemainingRound();

        assertAll(
                () -> assertThat(expectedTrue).isTrue(),
                () -> assertThat(expectedFalse).isFalse()
        );
    }

    @DisplayName("hasNotRemainingRound() 테스트 : 라운드가 남아있지 않다면 true를 반환, 남아있다면 false를 반환한다.")
    @Test
    void hasNotRemainingRound() {
        Round round1 = new Round(new Count(0));
        Round round2 = new Round(new Count(1));

        boolean expectedTrue = round1.hasNotRemainingRound();
        boolean expectedFalse = round2.hasNotRemainingRound();

        assertAll(
                () -> assertThat(expectedTrue).isTrue(),
                () -> assertThat(expectedFalse).isFalse()
        );
    }

    @DisplayName("finishCurrentRound() 테스트 : 라운드 수를 하나 감소시킨다.")
    @Test
    void finishCurrentRound() {
        Round round = new Round(new Count(5));

        round.finishCurrentRound();

        assertThat(round).usingRecursiveComparison()
                .comparingOnlyFields("count")
                .isEqualTo(new Round(new Count(4)));
    }

    @DisplayName("finishCurrentRound() 예외 테스트 : 더이상 감소시킬 라운드가 없는 경우에 IllegalArgumentException가 발생한다.")
    @Test
    void 예외발생_라운드횟수가_0일때_라운드를_감소시키려는_경우() {
        Round round = new Round(new Count(0));

        assertThatThrownBy(() -> round.finishCurrentRound())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 남은 라운드 횟수가 없습니다.");
    }
}