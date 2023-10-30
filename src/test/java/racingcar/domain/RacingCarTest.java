package racingcar.domain;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

        int round = 5;
        for (int i = 0; i < round; i++) {
            racingCar1.move();
            racingCar2.move();

        }
        assertThat(racingCar1.getMove()).isEqualTo(1);
        assertThat(racingCar2.getMove()).isEqualTo(6);
    }
}
