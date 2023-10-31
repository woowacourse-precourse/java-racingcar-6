package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 전진_성공() {
        //given
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    //when
                    car.move();
                    //then
                    assertThat(car.getMoveStatus()).isEqualTo(1);
                },
                4
        );
    }

    @Test
    void 전진_실패() {
        //given
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    //when
                    car.move();
                    //then
                    assertThat(car.getMoveStatus()).isEqualTo(0);
                },
                3
        );
    }

    @Test
    void 전진_여러번() {
        //given
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    //when
                    for (int i = 0; i < 10; i++) {
                        car.move();
                    }
                    //then
                    assertThat(car.getMoveStatus()).isEqualTo(7);
                },
                4, 5, 6, 7, 8, 9, 1, 2, 3, 4
        );
    }
}
