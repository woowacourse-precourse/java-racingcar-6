package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RoundTest {

    @DisplayName("hasRemainingRound() 테스트 : 라운드가 남아있다면 true를 반환, 남아있지 않다면 false를 반환한다.")
    @Test
    void hasRemainingRound() {
        Round round1 = new Round(1);
        Round round2 = new Round(0);

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
        Round round1 = new Round(0);
        Round round2 = new Round(1);

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
        Round round = new Round(5);

        round.finishCurrentRound();

        assertThat(round).usingRecursiveComparison()
                .comparingOnlyFields("count")
                .isEqualTo(new Round(4));
    }
}