package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import static racingcar.config.CarMoveRuleConfig.setCustomCarMoveRule;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import racingcar.model.car.Car;
import racingcar.model.car.CarMoveRule;

/**
 * docs/README.md <br/><br/> 요구사항 1 <br/><br/> 1-1. 자동차 전진 또는 정지 <br/>
 */
public class RacingCarTest {

    @Test
    void 자동차_전진() {
        // given
        /* 항상 전진하는 규칙 적용 */
        CarMoveRule alwaysMove = () -> true;
        setCustomCarMoveRule(alwaysMove);
        Car car = Car.from("zeus");

        int expected = 5;

        // when
        IntStream.range(0, expected).forEach(i -> car.goOrStop());

        // then
        int actual = car.getDistance();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차_정지() {
        // given
        /* 항상 정지하는 규칙 적용 */
        CarMoveRule alwaysStop = () -> false;
        setCustomCarMoveRule(alwaysStop);
        Car car = Car.from("zeus");

        int expected = 0;

        // when
        IntStream.range(0, 5).forEach(i -> car.goOrStop());

        // then
        int actual = car.getDistance();
        assertThat(actual).isEqualTo(expected);
    }
}
