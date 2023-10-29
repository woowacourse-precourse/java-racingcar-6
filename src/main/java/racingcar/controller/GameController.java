package racingcar.controller;

import racingcar.service.InputService;

public class GameController {
    private InputService inputService;

    public GameController() {
        this.inputService = new InputService();
    }

    public void Init() {
        inputService.readCarInput();
    }
}
