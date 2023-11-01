package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static racingcar.util.GameConstants.MAXIMUM_MOVE_COUNT;
import static racingcar.util.GameConstants.ZERO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.validator.moveCount.MoveCountValidator;
import racingcar.model.validator.moveCount.MoveCountValidatorImpl;

public class MoveCountInputTest {
    MoveCountValidator moveCountValidator;

    @BeforeEach
    void beforeEach() {
        moveCountValidator = new MoveCountValidatorImpl();
    }

    @Test
    @DisplayName("자료형에 부합할 경우 테스트를 통과한다.")
    public void 자료형에_부합할_경우_테스트를_통과한다() {
        // given
        Long input = Long.valueOf(MAXIMUM_MOVE_COUNT);

        // when & then
        assertThatNoException().isThrownBy(() -> moveCountValidator.validateType(input));
    }

    @Test
    @DisplayName("자료형에 부합하지 않을 경우 예외를 반환한다.")
    public void 자료형에_부합하지_않을_경우_예외를_반환한다() {
        // given
        Long input = Long.valueOf(MAXIMUM_MOVE_COUNT) + 1;

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> moveCountValidator.validateType(input));
    }

    @Test
    @DisplayName(ZERO + "일 경우 테스트를 통과한다.")
    public void ZERO일_경우_테스트를_통과한다() {
        // given
        Long input = Long.valueOf(ZERO);

        // when & then
        assertThatNoException().isThrownBy(() -> moveCountValidator.validatePositive(input));
    }

    @Test
    @DisplayName("음수일 경우 예외를 반환한다")
    public void 음수일_경우_예외를_반환한다() {
        // given
        Long input = Long.valueOf(MAXIMUM_MOVE_COUNT * -1);

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> moveCountValidator.validatePositive(input));
    }
}
