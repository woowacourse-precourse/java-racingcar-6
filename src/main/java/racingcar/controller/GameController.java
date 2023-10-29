package racingcar.controller;

import racingcar.repository.RacingGameRepository;
import racingcar.service.InputService;

public class GameController {
    private RacingGameRepository racingGameRepository;
    private InputService inputService;

    public GameController() {
        this.inputService = new InputService();
        this.racingGameRepository = new RacingGameRepository();
    }

    public void Init() {
        inputService.readCarInput();
        System.out.println(racingGameRepository.getCar());
        inputService.readMoveCountFromUser();
    }
}
