package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("RacingCar 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "jong"})
    void createRacingCarWithNameAndRetrieveIt(String carName) {
        RacingCar racingCar = new RacingCar(carName);

        assertThat(racingCar.getName()).isEqualTo(carName);
    }
}
