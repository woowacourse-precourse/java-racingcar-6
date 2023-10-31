package racingcar.controller;

import static racingcar.view.ConstantView.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import racingcar.config.AppConfig;
import racingcar.view.View;
import racingcar.model.Participants;
import racingcar.model.car.Car;
import racingcar.service.CarSaveService;
import racingcar.service.GetWinnersService;
import racingcar.service.raceservice.RaceService;

public class RacingGame {
    RaceService raceService = AppConfig.raceServiceImplements();

    public void run() {
        gameStartMessage();                                         // ConstantView static import
        String nameInput = InputHandler.readInput();
        String[] names = InputHandler.StringToArray(nameInput);
        Participants participants = CarSaveService.save(names);

        roundInputMessage();
        String roundInput = InputHandler.readInput();
        int round = InputHandler.StringToInteger(roundInput);

        raceStartMessage();
        for (int i = 0; i < round; i++) {
            Map<Car, Integer> map = raceService.runRace(participants);
            View.printRaceResult(map);
        }

        List<String> winnersNames = GetWinnersService.getWinnersNames(participants);
        View.printWinners(winnersNames);

        Console.close();
    }
}
