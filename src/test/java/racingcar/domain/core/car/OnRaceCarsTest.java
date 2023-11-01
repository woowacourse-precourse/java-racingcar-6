package racingcar.domain.core.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exceptions.runtime.NotFoundSourceException;

class OnRaceCarsTest {

    @Test
    @DisplayName("자동차들의 위치를 반환")
    void getPosition() {
        // given
        OnRaceCar car1 = new OnRaceCar(new Car(new CarName("a")), 0L);
        OnRaceCar car2 = new OnRaceCar(new Car(new CarName("b")), 1L);
        OnRaceCar car3 = new OnRaceCar(new Car(new CarName("c")), 2L);
        OnRaceCars cars = new OnRaceCars(List.of(car1, car2, car3));

        // when
        Long position1 = cars.getPosition(car1);
        Long position2 = cars.getPosition(car2);
        Long position3 = cars.getPosition(car3);

        // then
        Assertions.assertAll(() -> assertEquals(position1, 0L), () -> assertEquals(position2, 1L),
            () -> assertEquals(position3, 2L));
    }

    @Test
    @DisplayName("없는 자동차 조회시 예외 발생")
    void getPositionWithNotFoundCar() {
        // given
        OnRaceCar car1 = new OnRaceCar(new Car(new CarName("a")), 0L);
        OnRaceCar car2 = new OnRaceCar(new Car(new CarName("b")), 1L);
        OnRaceCar car3 = new OnRaceCar(new Car(new CarName("c")), 2L);
        OnRaceCars cars = new OnRaceCars(List.of(car1, car2, car3));

        // when
        OnRaceCar notExistCar = new OnRaceCar(new Car(new CarName("d")), 3L);

        // then
        assertThrows(NotFoundSourceException.class, () -> cars.getPosition(notExistCar));
    }
}