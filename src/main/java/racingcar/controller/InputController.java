package racingcar.controller;

import racingcar.service.InputService;

public class InputController {
    private InputService inputService;

    public InputController() {
        inputService = new InputService();
    }

    public void enterCarNamesAndCount() {
        inputService.requestInput();
    }

    public String getCarNames(){
        return inputService.getCarNames();
    }

    public int getRacingCount() {
        return inputService.getRacingCount();
    }
}
