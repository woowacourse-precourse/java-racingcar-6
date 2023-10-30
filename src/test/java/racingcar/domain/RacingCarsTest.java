package racingcar.domain;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarsTest {

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"pobi,juni,hun",
            "juni,crong,hun",
            "jun,hun,won"})
    void 자동차_생성_테스트(String names) {
        RacingCars racingCars = new RacingCars(names);

        assertThat(racingCars).isNotNull();
    }


}