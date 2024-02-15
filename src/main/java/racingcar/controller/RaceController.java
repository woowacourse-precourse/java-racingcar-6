package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.CompareRace;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RaceController {

    private InputView inputView;

    private OutputView outputView;

    private CompareRace compareRace;

    private final Integer MIN_MOVEMENT = 0;

    public RaceController() {
        inputView = new InputView();
        outputView = new OutputView();
        compareRace = new CompareRace();
    }

    public void run() {
        List<RacingCar> racingCars = inputView.inputCarName();
        Integer movement = inputView.inputMovement();

        List<RacingCar> doneRacingCars = race(racingCars, movement);
        List<RacingCar> winnerCarNames = compareWinner(doneRacingCars);

        outputView.resultRace(winnerCarNames);
    }

    private List<RacingCar> compareWinner(List<RacingCar> doneRacingCars) {
        return compareRace.findWinnerCars(doneRacingCars);
    }

    private List<RacingCar> race(List<RacingCar> racingCars, Integer movement) {
        IntStream.range(MIN_MOVEMENT, movement).forEach(i -> {
            compareRace.moveCars(racingCars);
            outputView.viewCarMovement(racingCars);
        });

        return racingCars;
    }
}
