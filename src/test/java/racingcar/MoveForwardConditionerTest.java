package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveForwardConditionerTest {

    @RepeatedTest(10)
    @DisplayName("랜덤 숫자 범위가 0~3 사이이면, false 를 리턴한다.")
    void test1() {
        // given
        MoveForwardConditioner moveForwardConditioner = new MoveForwardConditioner(0, 3);

        // when
        boolean result = moveForwardConditioner.canMoveForward();

        // then
        Assertions.assertThat(result).isEqualTo(false);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤 숫자 범위가 4~9 사이이면, true 를 리턴한다.")
    void test2() {
        // given
        MoveForwardConditioner moveForwardConditioner = new MoveForwardConditioner(4, 9);

        // when
        boolean result = moveForwardConditioner.canMoveForward();

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }
}