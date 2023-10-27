package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveRuleByMinimumScoreTest {
    private NumberGenerator getTargetNumber(int number) {
        return new RandomNumberGenerator() {
            @Override
            public int generate() {
                return number;
            }
        };
    }

    @Test
    @DisplayName("숫자가 4면 1을 반환한다.")
    void 숫자4_1_반환() {
        //given
        NumberGenerator numberGenerator = getTargetNumber(4);
        MoveRule moveRule = new MoveRuleByMinimumScore(numberGenerator);
        //when
        int distance = moveRule.tryMove();
        //then
        assertThat(distance).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 5면 1을 반환한다.")
    void 숫자5_1_반환() {
        //given
        NumberGenerator numberGenerator = getTargetNumber(5);
        MoveRule moveRule = new MoveRuleByMinimumScore(numberGenerator);
        //when
        int distance = moveRule.tryMove();
        //then
        assertThat(distance).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 3면 0을 반환한다.")
    void 숫자3_0_반환() {
        //given
        NumberGenerator numberGenerator = getTargetNumber(3);
        MoveRule moveRule = new MoveRuleByMinimumScore(numberGenerator);
        //when
        int distance = moveRule.tryMove();
        //then
        assertThat(distance).isZero();
    }

    @RepeatedTest(value = 20)
    @DisplayName("0 ~ 9 사이의 숫자가 나오면 성공한다.")
    void RandomNumberGeneratorTest() {
        //given
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        //when,then
        assertThat(numberGenerator.generate()).isBetween(0, 9);
    }
}