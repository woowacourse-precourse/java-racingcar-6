package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.global.enums.ExceptionMessage.TRIAL_MINIMUM_MESSAGE;

import org.junit.jupiter.api.Test;

class TrialTest {

    @Test
    void 시행_횟수_1_미만_예외_테스트() {
        //when and then
        assertThatThrownBy(() -> new Trial(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRIAL_MINIMUM_MESSAGE.getMessage());
    }

    @Test
    void 시행_횟수_1_이상_정상_테스트() {
        //given
        int expectedResult = 1;
        Trial trial = new Trial(expectedResult);

        //when
        int actualResult = trial.get();

        //then
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}