package racingcar.domain.system.game.round;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;
import racingcar.domain.core.car.MoveSignal;
import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.core.car.OnRaceCars;
import racingcar.domain.system.game.round.result.RoundResult;
import racingcar.domain.system.host.Host;

class RoundTest {

    @Test
    @DisplayName("라운드 시작")
    void start() {
        // given
        Host host = new ForwardHost();
        OnRaceCar car1 = new OnRaceCar(new Car(new CarName("a")), 0L);
        OnRaceCar car2 = new OnRaceCar(new Car(new CarName("b")), 0L);
        OnRaceCar car3 = new OnRaceCar(new Car(new CarName("c")), 0L);
        OnRaceCars cars = new OnRaceCars(List.of(car1, car2, car3));

        Round round = Round.start(host, cars);

        // when
        RoundResult roundResult = round.play();

        // then
        for (OnRaceCar car : roundResult.getAllCars()) {
            assertEquals(1L , car.getPosition());
        }
    }

    private static class ForwardHost extends Host {

        @Override
        protected MoveSignal getSignal() {
            return MoveSignal.FORWARD;
        }
    }
}