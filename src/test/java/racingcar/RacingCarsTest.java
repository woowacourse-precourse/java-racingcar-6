package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCars;
import stub.RacingCarsStub;

public class RacingCarsTest extends RacingCarsStub {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = RacingCars.from(CAR_NAMES);
    }

    @Test
    void 자동차의_이름을_콤마로_연결하여_반환한다() {
        assertThat(racingCars.toNameString())
                .isEqualTo(JOINED_CAR_NAMES);
    }
}
