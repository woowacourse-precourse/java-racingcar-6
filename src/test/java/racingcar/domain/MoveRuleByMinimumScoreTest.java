package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveRuleByMinimumScoreTest {
    @Test
    @DisplayName("숫자가 4면 1을 반환한다.")
    void 숫자4_1_반환() {
        //given
        MoveRule moveRule = new MoveRuleByMinimumScore();
        //when
        //then
        assertThat(moveRule.tryMove(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 5면 1을 반환한다.")
    void 숫자5_1_반환() {
        //given
        MoveRule moveRule = new MoveRuleByMinimumScore();
        //when
        //then
        assertThat(moveRule.tryMove(5)).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 4면 1을 반환한다.")
    void 숫자3_0_반환() {
        //given
        MoveRule moveRule = new MoveRuleByMinimumScore();
        //when
        //then
        assertThat(moveRule.tryMove(3)).isZero();
    }

    @RepeatedTest(value = 20)
    @DisplayName("0 ~ 9 사이의 숫자가 나오면 성공한다.")
    void RandomNumberGeneratorTest() {
        //given
        MoveRule numberGenerator = new MoveRuleByMinimumScore();
        //when,then
        Assertions.assertThat(numberGenerator.generate()).isBetween(0, 9);
    }
}