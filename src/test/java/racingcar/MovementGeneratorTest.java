package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.GameConstants.MAXIMUM_GENERATED_NUM;
import static racingcar.util.GameConstants.MINIMUM_GENERATED_NUM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.generator.RandomGenerator;

public class MovementGeneratorTest {

    static MovementGenerator movementGenerator;

    @BeforeEach
    void beforeEach() {
        movementGenerator = new RandomGenerator();
    }

    @Test
    @DisplayName("생성된 value가 범위 내인지 확인한다.")
    public void 생성된_value가_범위_내인지_확인한다() {
        // given
        // when & then
        assertThat(movementGenerator.generateMovement()).isBetween(MINIMUM_GENERATED_NUM, MAXIMUM_GENERATED_NUM);
    }
}
