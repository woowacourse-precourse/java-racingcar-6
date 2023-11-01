package racingcar.domain.core.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.domain.core.car.MoveSignal.FORWARD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OnRaceCarTest {

    @Test
    @DisplayName("전진(1) 시그럴을 받으면 차는 전잔한다.")
    void move_forward() {
        // given
        Car car = new Car(new CarName("a"));
        MovingCar onRaceCar = new OnRaceCar(car, 0L);

        // when
        OnRaceCar movedCar = onRaceCar.move(FORWARD);

        // then
        assertEquals(movedCar.getPosition(), 1L);
    }


    @Test
    @DisplayName("정지(0) 시그널을 받으면 차는 정지한다.")
    void move_stop() {
        // given
        Car car = new Car(new CarName("a"));
        MovingCar onRaceCar = new OnRaceCar(car, 0L);

        // when
        OnRaceCar movedCar = onRaceCar.move(MoveSignal.STOP);

        // then
        assertEquals(movedCar.getPosition(), 0L);
    }

    @Test
    @DisplayName("자동차의 이름을 반환한다.")
    void getName() {
        // given
        Car car = new Car(new CarName("a"));
        OnRaceCar onRaceCar = new OnRaceCar(car, 0L);

        // when
        CarName name = onRaceCar.getCarName();

        // then
        assertEquals(name, new CarName("a"));
    }
}