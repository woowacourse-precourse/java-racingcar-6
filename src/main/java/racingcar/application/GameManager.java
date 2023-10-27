package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.DefaultFuelFactory;
import racingcar.domain.FuelFactory;
import racingcar.domain.GameTry;

public class GameManager {
    private static final FuelFactory FUEL_FACTORY = new DefaultFuelFactory();

    private Cars cars;
    private GameTry gameTry;

    public void run() {
    }
}
