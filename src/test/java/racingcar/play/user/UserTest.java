package racingcar.play.user;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;

class UserTest  extends NsTest {

    @Test
    void 사용자_시도_회수_성공(){
        //given
        String input = "Car1,Car2";
        String count = "1";
        //when

        //then
        assertRandomNumberInRangeTest(
            () -> {
                run(input, count);
                assertThat(output()).contains("Car1 : -", "Car2 : ", "최종 우승자 : Car1");
            },
            4, 3
        );
    }

    @Test
    void 사용자_시도_회수_실패(){
        //given
        String input = "Car1, Car2";
        String count = "avsd";
        //when

        //then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input, count))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() { Application.main(new String[]{}); }
}
