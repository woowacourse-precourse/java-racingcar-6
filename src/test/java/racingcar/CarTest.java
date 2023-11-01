package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void init_이름이5글자이하_오류없음() {
        Assertions.assertDoesNotThrow(() -> new Car("testt"));
    }

    @Test
    void init_이름이5글자초과_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Car("asdfasdf"));
    }

    @Test
    void init_이름이비었음_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Car(""));
    }

    @Test
    void updateScore_점수얻기성공_오류없음() {
        Car test = new Car("TEST");
        assertRandomNumberInRangeTest(
                () -> {
                    test.updateScore();
                    assertThat(1).isEqualTo(test.getScore());
                },
            4
        );
    }

    @Test
    void updateScore_점수얻기실패_오류없음() {
        Car test = new Car("TEST");
        assertRandomNumberInRangeTest(
                () -> {
                    test.updateScore();
                    assertThat(0).isEqualTo(test.getScore());
                },
                3
        );
    }
}
