package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.CarRepository;
import racingcar.Model.Race.Race;

public class MainController {
    RaceController raceController = new RaceControllerIntegerRange();

    public void collectParticipant (String input) {
        generateCarRepository(input);
    }

    public void processRace (String input, CarRepository carRepository) {
        raceController.race(input, carRepository);
    }

    private void generateCarRepository(String input) {
    }


}
