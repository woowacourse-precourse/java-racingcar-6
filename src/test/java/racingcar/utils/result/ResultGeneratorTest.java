package racingcar.utils.result;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class ResultGeneratorTest {

    private static final String CAR_NAME1 = "p1";
    private static final String CAR_NAME2 = "p2";
    private static final CharSequence[] RESULT_SEQUENCES = {"p1 : -", "p2 : -"};
    private static final CharSequence[] WINNER_SEQUENCES = {"최종 우승자 : ", "p1, p2"};
    ResultGenerator resultGenerator = new ResultGenerator();

    @Test
    void 실행결과_테스트() {
        // given
        Car car1 = Car.of(CAR_NAME1);
        Car car2 = Car.of(CAR_NAME2);
        car1.move();
        car2.move();

        // when
        String result = resultGenerator.makeExecutionResult(Arrays.asList(car1, car2));

        // then
        assertThat(result).contains(RESULT_SEQUENCES);
    }

    @Test
    void 우승자_테스트() {
        // given
        Car car1 = Car.of(CAR_NAME1);
        Car car2 = Car.of(CAR_NAME2);

        // when
        String result = resultGenerator.makeWinnersResult(Arrays.asList(car1, car2));

        // then
        assertThat(result).contains(WINNER_SEQUENCES);
    }


}