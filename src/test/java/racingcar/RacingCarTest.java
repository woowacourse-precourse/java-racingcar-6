package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.enums.Symbol;
import racingcar.model.RacingCar;
import stub.RacingCarStub;

public class RacingCarTest extends RacingCarStub {
    private RacingCar racingCar;


    @BeforeEach
    void setUp() {
        racingCar = RacingCar.from(CAR_NAME);
    }

    @Test
    void 전진하면_위치가_1_증가한다() {
        racingCar.moveForward();

        assertThat(racingCar.getPosition())
                .isEqualTo(1);
    }

    @Test
    void 위치가_증가했을_때_getPositionMarker_메서드가_마커를_위치만큼_반환한다() {
        int repeatCount = (int) (Math.random() * 100);

        IntStream.range(0, repeatCount)
                .forEach(i -> racingCar.moveForward());

        assertThat(racingCar.getPositionMarkers())
                .isEqualTo(Symbol.POSITION_MARKER.getValue().repeat(repeatCount));
    }
}
