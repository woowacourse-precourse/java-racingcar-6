package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorCode;
import racingcar.model.intgenerator.CustomIntGenerator;
import racingcar.model.intgenerator.IntGenerator;

public class RacingTest {
    private static final int MOVING_CONDITION = 4;
    private static final int ONE_STEP = 1;
    private List<String> defaultNames;
    private IntGenerator defaultGenerator;
    private Racing defaultRacing;

    @BeforeEach
    void setUp() {
        defaultNames = List.of("pobi", "woni");
        defaultGenerator = new CustomIntGenerator(MOVING_CONDITION);
        defaultRacing = new Racing(defaultNames, 1, defaultGenerator);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 경주_생성시_이동_시도_횟수가_0회_이하면_예외가_발생한다(int tryCount) {
        assertThatThrownBy(() -> new Racing(defaultNames, tryCount, defaultGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NON_POSITIVE_TRY_COUNT.getMessage());
    }

    @Test
    void 이동시_전진을_시도해_자동차들의_상태를_변경할_수_있다() {
        int beforeForwardCount = defaultRacing.captureCurrentState().get(0).forwardCount();

        defaultRacing.doMove();

        int afterForwardCount = defaultRacing.captureCurrentState().get(0).forwardCount();
        assertThat(afterForwardCount).isEqualTo(beforeForwardCount + ONE_STEP);
    }

    @Test
    void 이동_후_이동_시도_횟수가_0회가_되면_이동_불가하다고_판단한다() {
        boolean before = defaultRacing.canMove();

        defaultRacing.doMove();

        boolean after = defaultRacing.canMove();
        assertThat(before).isTrue();
        assertThat(after).isFalse();
    }

    @Test
    void 현재_경주_상태_확인_시_자동차들의_이름과_전진횟수를_확인할_수_있다() {
        List<CarState> states = defaultRacing.captureCurrentState();

        for (int i = 0; i < 2; i++) {
            assertThat(states.get(i).name()).isEqualTo(defaultNames.get(i));
            assertThat(states.get(i).forwardCount()).isEqualTo(0);
        }
    }

    @Test
    void 최대_전진횟수를_가진_자동차이름으로_경주의_우승자_이름을_생성한다() {
        List<String> names = defaultRacing.generateWinnerNames();

        assertThat(names).isEqualTo(defaultNames);
    }
}
