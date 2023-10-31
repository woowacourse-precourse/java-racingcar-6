package racingcar.domain;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"pobi",
            "juni",
            "jun"})
    void 자동차_생성_테스트(String name) {
        RacingCar racingCar = new RacingCar(name, 0);

        assertThat(racingCar).isNotNull();
    }

    @Test
    void 자동차_전진_테스트() {
        RacingCar racingCar1 = new RacingCar("juni", 1, bound -> 3);
        RacingCar racingCar2 = new RacingCar("huni", 1, bound -> 4);

        racingCar1.testMove();
        racingCar2.testMove();

        assertThat(racingCar1.getMove()).isEqualTo(1);
        assertThat(racingCar2.getMove()).isEqualTo(2);
    }
}
