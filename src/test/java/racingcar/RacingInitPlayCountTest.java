package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingInitPlayCountTest {

    private static Racing racing;

    @BeforeEach
    void init() {
        racing = new Racing();
    }

    @Test
    @DisplayName("initPlayCount 부족 실패 테스트")
    void initPlayCount_lack_fail() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initPlayCount(0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initPlayCount 초과 실패 테스트")
    void initPlayCount_over_fail() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initPlayCount(11))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initPlayCount 검증 테스트")
    void initPlayCount_validate() {
        racing.initPlayCount(5);
        assertThat(racing.getPlayCount()).isEqualTo(5);
    }

}
