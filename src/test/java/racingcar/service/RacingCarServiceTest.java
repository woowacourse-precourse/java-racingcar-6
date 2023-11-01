package racingcar.service;

import static org.mockito.Mockito.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.domain.Car;

class RacingCarServiceTest {
    RacingCarService racingCarService = new RacingCarService();

    @Test
    void race_4이상_전진() {
        try (MockedStatic<Randoms> randomsMock = Mockito.mockStatic(Randoms.class)) {
            randomsMock.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(5);

            // given
            Car mockCar1 = mock(Car.class);
            Car mockCar2 = mock(Car.class);
            List<Car> carList = Arrays.asList(mockCar1, mockCar2);

            // when
            racingCarService.race(carList);

            // then
            verify(mockCar1).go();
            verify(mockCar2).go();
        }
    }

    @Test
    void race_4미만_정지() {
        try (MockedStatic<Randoms> randomsMock = Mockito.mockStatic(Randoms.class)) {
            randomsMock.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(3);

            // given
            Car mockCar1 = mock(Car.class);
            Car mockCar2 = mock(Car.class);
            List<Car> carList = Arrays.asList(mockCar1, mockCar2);

            // when
            racingCarService.race(carList);

            // then
            verify(mockCar1, never()).go();
            verify(mockCar2, never()).go();
        }
    }
}