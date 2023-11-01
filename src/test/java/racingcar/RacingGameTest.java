package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest extends NsTest{
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi","1");
                    assertThat(output()).contains("pobi : -");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi","1");
                    assertThat(output()).contains("pobi :");
                },
                STOP
        );
    }

    @Test
    void 우승자_중복_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void Car_객체_생성_테스트(){
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        assertThat(car1).isNotEqualTo(car2);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}