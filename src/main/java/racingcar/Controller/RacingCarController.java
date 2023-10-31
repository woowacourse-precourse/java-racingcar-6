package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.Model.Race;
import racingcar.Model.RacingCar;
import racingcar.View.RacingCarView;

public class RacingCarController {

    private Race race;
    private RacingCarView view;

    public RacingCarController() {
        view = new RacingCarView();
    }

    public void startGame() {
        String input = view.getCarNames();
        String[] carNames = input.split(",");
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(carName);
            racingCars.add(racingCar);
        }
        int rounds = view.getRoundsInput();

        race = new Race(racingCars, rounds, view);

        race.run();

        view.printWinners(race.getWinners());
    }
}
