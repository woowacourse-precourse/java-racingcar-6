package racingcar.policy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingCarGameMovingPolicyTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 정책에_따라_4_이상이면_움직일_수_있다(int number) {
        // given
        RacingCarGameMovingPolicy racingCarGameMovingPolicy = new RacingCarGameMovingPolicy();

        // when
        boolean canMove = racingCarGameMovingPolicy.canMove(number);

        // then
        assertThat(canMove).isTrue();
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {0,1,2,3})
    void 정책에_따라_4_미만이면_움직일_수_없다(int number) {
        // given
        RacingCarGameMovingPolicy racingCarGameMovingPolicy = new RacingCarGameMovingPolicy();

        // when
        boolean canMove = racingCarGameMovingPolicy.canMove(number);

        // then
        assertThat(canMove).isFalse();
    }

}