package racingcar.domain.player;

import java.math.BigInteger;
import java.util.List;
import racingcar.domain.car.Car;

public interface RacingPlayer {
        List<Car> submitRacingCarList(int nameLength);
        BigInteger submitLaps();
}
