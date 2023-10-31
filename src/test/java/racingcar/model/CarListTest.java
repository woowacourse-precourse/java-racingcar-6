package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;


class CarListTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void 자동차_이름에_중복이_있으면_예외() {
        String input = "a,a,a";

        assertThrows(IllegalArgumentException.class, () -> {
            new CarList(input);
        });
    }

    @Test
    public void split_으로_주어진_자동차_이름을_구분() {
        //given
        String input = "a,b,c";
        //when
        CarList result = new CarList(input);
        //then
        assertThat(result.getCarList()).containsExactly(new Car("a"), new Car("b"), new Car("c"));
    }

    @Test
    public void move_메서드_사용시_모든_자동차가_움직인다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2", "1");
                    assertThat(output()).contains("car1 : ", "car2 : -");
                },
                STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}