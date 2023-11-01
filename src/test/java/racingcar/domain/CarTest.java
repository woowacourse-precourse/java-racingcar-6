package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class CarTest {

    @Test
    void 랜덤값이_4이상일_경우_움직인다() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 5, 9);
            Car car = new Car("m");
            IntStream.range(0, 3).forEach(i -> car.move());
            assertEquals(car.getPosition(), 3);
        }
    }

    @Test
    void 랜덤값이_3이하일_경우_정지한다() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(0, 1, 2);
            Car car = new Car("m");
            IntStream.range(0, 3).forEach(i -> car.move());
            assertEquals(car.getPosition(), 0);
        }
    }
}