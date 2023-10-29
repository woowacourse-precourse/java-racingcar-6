package racingcar.config;

import racingcar.factory.Factory;
import racingcar.factory.impl.CarFactory;
import racingcar.game.Game;
import racingcar.game.impl.RacingGame;
import racingcar.ioadapter.IoAdapter;
import racingcar.ioadapter.impl.StandardIoAdapter;
import racingcar.service.InputConvertService;
import racingcar.service.RacingService;
import racingcar.service.ValidateService;
import racingcar.service.impl.InputConvertServiceImpl;
import racingcar.service.impl.RacingServiceImpl;
import racingcar.service.impl.ValidateServiceImpl;

public class AppConfig {

    public IoAdapter ioAdapter() {
        return new StandardIoAdapter();
    }

    public ValidateService validateService() {
        return new ValidateServiceImpl();
    }

    public RacingService racingService() {
        return new RacingServiceImpl();
    }

    public InputConvertService inputConvertService() {
        return new InputConvertServiceImpl(validateService());
    }

    public Factory factory() {
        return new CarFactory(racingService());
    }

    public Game game() {
        return new RacingGame(factory());
    }
}
