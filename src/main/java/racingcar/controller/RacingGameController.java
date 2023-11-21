package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.TryCount;
import racingcar.service.CreateCharacterService;
import racingcar.service.CreateTryCountService;
import racingcar.service.RacingGameService;

public class RacingGameController {
    private final RacingGameService racingGameService;
    private final CreateCharacterService createCharacterService;
    private final CreateTryCountService createTryCountService;


    public RacingGameController(RacingGameService racingGameService, CreateCharacterService createCharacterService,
                                CreateTryCountService createTryCountService) {
        this.racingGameService = racingGameService;
        this.createCharacterService = createCharacterService;
        this.createTryCountService = createTryCountService;
    }

    public void GameStart() {
        List<Car> cars = createCharacterService.createCharacter();
        TryCount tryCount = createTryCountService.createTryCount();
        racingGameService.playGame(cars, tryCount);
        racingGameService.findWinner(cars);
    }
}
