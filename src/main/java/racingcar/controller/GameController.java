package racingcar.controller;

import racingcar.repository.RacingGameRepository;
import racingcar.service.InputService;
import racingcar.service.OutputService;
import racingcar.service.RacingGameService;

public class GameController {
    private RacingGameRepository racingGameRepository;
    private InputService inputService;
    private RacingGameService racingGameService;
    private OutputService outputService;

    public GameController() {
        this.racingGameRepository = new RacingGameRepository();
        this.inputService = new InputService(racingGameRepository);
        this.racingGameService = new RacingGameService(racingGameRepository);
        this.outputService = new OutputService(racingGameRepository, racingGameService);
    }

    public void Init() {
        inputService.readCarInput();
        int moveCount = inputService.readMoveCountFromUser();
        for (int i = 0; i < moveCount; i++) {
            racingGameService.move();
            outputService.printSingleResult();
        }
    }
}
