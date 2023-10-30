package racingcar;

import racingcar.model.Participants;
import racingcar.service.CarSaveService;

public class RacingGame {

    public void process() {
        String[] names = InputHandler.getInputTypeToStringArray();
        Participants cars = CarSaveService.save(names);
    }
}
