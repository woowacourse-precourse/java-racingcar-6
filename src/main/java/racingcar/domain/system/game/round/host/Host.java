package racingcar.domain.system.game.round.host;

import racingcar.domain.core.car.MoveSignal;
import racingcar.domain.core.car.OnRaceCar;

public abstract class Host {

    public OnRaceCar signal(OnRaceCar car) {
        return car.move(getSignal());
    }

    protected abstract MoveSignal getSignal();
}
