package racingcar.domain.system.host;

import racingcar.domain.core.car.MoveSignal;
import racingcar.domain.core.car.MovingCar;
import racingcar.domain.core.car.OnRaceCar;

public abstract class Host {

    public OnRaceCar signal(MovingCar car) {
        return car.move(getSignal());
    }

    protected abstract MoveSignal getSignal();
}
