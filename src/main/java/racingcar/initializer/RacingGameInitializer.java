package racingcar.initializer;

import racingcar.domain.system.game.Game;
import racingcar.domain.system.game.RacingGame;
import racingcar.domain.system.host.Host;
import racingcar.domain.system.host.RandomSignalHost;
import racingcar.domain.system.manager.car.CarManager;
import racingcar.domain.system.manager.car.InMemoryCarManager;
import racingcar.domain.system.manager.position.CarPositionManager;
import racingcar.domain.system.manager.position.InMemoryCarPositionManager;

public class RacingGameInitializer {

    public Game getGame() {
        ConsoleGameFactory factory = new ConsoleGameFactory();
        Host host = new RandomSignalHost();
        CarManager carManager = new InMemoryCarManager();
        CarPositionManager carPositionManager = new InMemoryCarPositionManager();
        return new RacingGame(factory, host, carManager, carPositionManager);
    }
}
