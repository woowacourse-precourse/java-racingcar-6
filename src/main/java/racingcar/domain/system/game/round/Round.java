package racingcar.domain.system.game.round;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.core.car.OnRaceCars;
import racingcar.domain.system.game.round.reuslt.RoundResult;
import racingcar.domain.system.host.Host;

public class Round {

    private final Host host;
    private final OnRaceCars cars;

    private Round(Host host, OnRaceCars cars) {
        this.host = host;
        this.cars = cars;
    }

    public static Round start(Host host, OnRaceCars cars) {
        return new Round(host, cars);
    }

    public RoundResult play() {
        List<OnRaceCar> movedCars = new ArrayList<>();
        for (OnRaceCar car : cars) {
            OnRaceCar movedCar = host.signal(car);
            movedCars.add(movedCar);
        }
        OnRaceCars movedOnRaceCars = new OnRaceCars(movedCars);
        return new RoundResult(movedOnRaceCars);
    }
}
