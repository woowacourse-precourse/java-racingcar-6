package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static racingcar.testutil.TestConstant.*;

class RacingcarGameServiceTest {

    private RacingcarGameService racingcarGameService = new RacingcarGameServiceImpl();

    @DisplayName("경주에 참가할 자동차들을 생성한다.")
    @Test
    void generateCarsToRace() {
        // given
        RacingcarGameService racingcarGameService = new RacingcarGameServiceImpl();
        String inputMessage = CAR_NAME1 + "," + CAR_NAME2 + "," + CAR_NAME3;

        // when
        Cars cars = racingcarGameService.generateCarsToRace(inputMessage);

        // then
        Assertions.assertThat(cars.getCars()).hasSize(3)
                .extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple(CAR_NAME1, 0),
                        tuple(CAR_NAME2, 0),
                        tuple(CAR_NAME3, 0)
                );
    }

}