package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarsTest {
    private static final int MOVE_FORWARD = 5;
    private static final int STOP = 1;

    @Test
    void play() {
        Cars cars = Cars.create(Arrays.asList("car1", "car2"));

        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVE_FORWARD)
                    .thenReturn(STOP)
                    .thenReturn(MOVE_FORWARD)
                    .thenReturn(STOP);

            cars.play();
        }
        List<Car> winners = cars.determineWinners();
        assertThat(winners.size()).isEqualTo(1);
    }
}