package racingcar.domain.formula;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.generator.MockNumberGenerator;

public class MoveFormulaTest {

    @Test
    @DisplayName("무작위 값이 4 이상이면 전진한다.")
    void 무작위_값이_4_이상이면_전진한다() {
        // given
        var mockNumberGenerator = new MockNumberGenerator(4);
        var moveFormula = new MoveFormula(mockNumberGenerator);

        // when
        var actual = moveFormula.move();

        // then
        assertThat(actual).isEqualTo(MoveState.MOVING_FORWARD);
    }

    @Test
    @DisplayName("무작위 값이 3 이하이면 멈춘다.")
    void 무작위_값이_3_이하이면_멈춘다() {
        // given
        var mockNumberGenerator = new MockNumberGenerator(3);
        var moveFormula = new MoveFormula(mockNumberGenerator);

        // when
        var actual = moveFormula.move();

        // then
        assertThat(actual).isEqualTo(MoveState.STOP);
    }
}
