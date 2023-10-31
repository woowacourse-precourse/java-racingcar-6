package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.model.car.Car;

public class RacingCarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    RacingCarService service = new RacingCarService();

    @Test
    void 자동차는_4이상일때_전진한다() {
        Car car1 = new Car("a", 0, (minBound, maxBound) -> 3);
        car1.move();
        assertThat(car1.getPosition()).isEqualTo(0);

        Car car2 = new Car("b", 0, (minBound, maxBound) -> 4);
        car2.move();
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    void 전진_안한_자동차는_아무것도_출력하지_않는다() {
        //given
        String userInputCarNames = "a";
        List<String> carNameList = service.createCarNameList(userInputCarNames);
        service.createCarList(carNameList);

        //when
        String racingResult = service.racingResult();

        //then
        assertThat(racingResult).isEqualTo(userInputCarNames + " : ");
    }

    @Test
    void 한번이상_전진후_결과_변환() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a", "2");
                    assertThat(output()).contains("a : --");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 레이싱_결과() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
