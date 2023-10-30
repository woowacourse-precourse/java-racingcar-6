package racingcar.controller;

import racingcar.controller.InputHandler;
import racingcar.model.Participants;
import racingcar.service.CarSaveService;

public class RacingGame {

    public void process() {
        String input = InputHandler.readInput();
        String[] names = InputHandler.StringToArray(input);
        Participants cars = CarSaveService.save(names);
    }
}
