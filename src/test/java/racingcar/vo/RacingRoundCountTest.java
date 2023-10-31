package racingcar.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingRoundCountTest {

    @Test
    void RacingRoundCount_생성() {
        RacingRoundCount racingRoundCount = new RacingRoundCount("12");
        Assertions.assertThat(racingRoundCount.value()).isEqualTo(12);
    }

    @Test
    void 문자열을_정수_int_로_바꾸지_못하는_경우_예외() {
        // RacingRoundCountValidatorTest 참고
        String input = "12 3";
        assertThatThrownBy(() -> new RacingRoundCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void vo_value_검사() {
        RacingRoundCount racingRoundCount = new RacingRoundCount("12");
        Assertions.assertThat(racingRoundCount.value()).isEqualTo(12);
    }

    @Test
    void 값이_같은_vo_동등하다() {
        RacingRoundCount racingRoundCount1 = new RacingRoundCount("12");
        RacingRoundCount racingRoundCount2 = new RacingRoundCount("12");
        Assertions.assertThat(racingRoundCount1.value()).isEqualTo(racingRoundCount1.value());
        Assertions.assertThat(racingRoundCount2).isEqualTo(racingRoundCount2);
    }

    @Test
    void 값이_같은_vo는_동일하다() {
        RacingRoundCount racingRoundCount1 = new RacingRoundCount("12");
        RacingRoundCount racingRoundCount2 = new RacingRoundCount("12");
        Assertions.assertThat(racingRoundCount1).hasSameHashCodeAs(racingRoundCount2);
    }

    @Test
    void 값이_다른_vo는_동등하지않다() {
        RacingRoundCount racingRoundCount1 = new RacingRoundCount("5");
        RacingRoundCount racingRoundCount2 = new RacingRoundCount("15");
        Assertions.assertThat(racingRoundCount1).isNotEqualTo(racingRoundCount2);
    }

    @Test
    void 값이_다른_vo는_동일하지않다() {
        RacingRoundCount racingRoundCount1 = new RacingRoundCount("5");
        RacingRoundCount racingRoundCount2 = new RacingRoundCount("15");
        Assertions.assertThat(racingRoundCount1).doesNotHaveSameHashCodeAs(racingRoundCount2);
    }

    @Test
    void 값은_타입의_같은_값인경우_동등_동일하다() {
        RacingRoundCount racingRoundCount = new RacingRoundCount("12");
        Integer integerValue = Integer.parseInt("12");
        Assertions.assertThat(integerValue).isEqualTo(racingRoundCount.value());
        Assertions.assertThat(integerValue).hasSameHashCodeAs(racingRoundCount);

        Integer intValue = Integer.parseInt("12");
        Assertions.assertThat(intValue).isEqualTo(racingRoundCount.value());
        Assertions.assertThat(intValue).hasSameHashCodeAs(racingRoundCount);
    }
}
