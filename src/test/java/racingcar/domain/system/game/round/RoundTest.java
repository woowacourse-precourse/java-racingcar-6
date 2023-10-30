package racingcar.domain.system.game.round;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;
import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.core.car.OnRaceCars;
import racingcar.domain.system.game.round.reuslt.RoundResult;
import racingcar.domain.system.host.RandomSignalHost;

class RoundTest {

    @Test
    @DisplayName("라운드 시작")
    void start() {
        // given
        RandomSignalHost host = new RandomSignalHost();
        OnRaceCar car1 = new OnRaceCar(new Car(new CarName("a")), 0L);
        OnRaceCar car2 = new OnRaceCar(new Car(new CarName("b")), 0L);
        OnRaceCar car3 = new OnRaceCar(new Car(new CarName("c")), 0L);
        OnRaceCars cars = new OnRaceCars(List.of(car1, car2, car3));

        Round round = Round.start(host, cars);

        // when
        RoundResult roundResult = round.play();

        // then
        for (OnRaceCar car : roundResult.getAllCars()) {
            assertTrue(car.getPosition() >= 0L);
        }
    }
}