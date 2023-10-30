package racingcar.controller;

import java.util.Map;
import racingcar.AppConfig;
import racingcar.controller.InputHandler;
import racingcar.model.Participants;
import racingcar.service.CarSaveService;
import racingcar.service.RaceService;

public class RacingGame {
    RaceService raceService = AppConfig.raceServiceImplements();
    public void process() {
        String input = InputHandler.readInput();
        String[] names = InputHandler.StringToArray(input);
        Participants cars = CarSaveService.save(names);

        Map map = raceService.runRace(cars);
    }
}
