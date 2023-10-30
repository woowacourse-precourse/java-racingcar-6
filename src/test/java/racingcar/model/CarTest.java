package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarFixtures.POBY;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4,5,6,7,8,9"})
    public void 무작위_값이_4_이상이라면_전진한다(final int random) {
        // given
        Car car = POBY.생성();

        // when & then
        assertRandomNumberInRangeTest(
            () -> {
                car.move();
                assertThat(car.getMoveCount()).isEqualTo(1);
            },
            random
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1,2,3"})
    public void 무작위_값이_4_미만이라면_전진하지_않는다(final int random) {
        // given
        Car car = POBY.생성();

        // when & then
        assertRandomNumberInRangeTest(
            () -> {
                car.move();
                assertThat(car.getMoveCount()).isEqualTo(0);
            },
            random
        );
    }

}