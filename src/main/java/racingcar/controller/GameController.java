package racingcar.controller;

import racingcar.repository.RacingGameRepository;
import racingcar.service.InputService;
import racingcar.service.RacingGameService;

public class GameController {
    private RacingGameRepository racingGameRepository;
    private InputService inputService;
    private RacingGameService racingGameService;

    public GameController() {
        this.inputService = new InputService();
        this.racingGameRepository = new RacingGameRepository();
        this.racingGameService = new RacingGameService();
    }

    public void Init() {
        inputService.readCarInput();
        System.out.println(racingGameRepository.getCar());
        int moveCount = inputService.readMoveCountFromUser();
        for (int i = 0; i < moveCount; i++) {
            racingGameService.move();
            System.out.println(racingGameRepository.getCar());
        }
    }
}
