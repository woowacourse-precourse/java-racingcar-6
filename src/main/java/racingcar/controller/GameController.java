package racingcar.controller;

import racingcar.repository.RacingGameRepository;
import racingcar.service.InputService;
import racingcar.service.OutputService;
import racingcar.service.RacingGameService;

public class GameController {
    private RacingGameRepository racingGameRepository;
    private InputService inputService;
    private OutputService outputService;
    private RacingGameService racingGameService;

    public GameController() {
        this.racingGameRepository = new RacingGameRepository();
        this.inputService = new InputService(racingGameRepository);
        this.outputService = new OutputService(racingGameRepository);
        this.racingGameService = new RacingGameService(racingGameRepository, outputService);
    }

    public void Init() {
        inputService.readCarInput();
        int moveCount = inputService.readMoveCountFromUser();
        racingGameService.runRace(moveCount);
    }
}
