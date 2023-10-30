package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.service.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final Race race;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(final Race race, final InputView inputView, final OutputView outputView) {
        this.race = race;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace(){
        List<Car> cars = inputView.getCarList();
        int count = inputView.getCountTry();

        outputView.printRaceResultStart();
        for(int i = 0; i<count; i++) {
            List<Car> car = race.start(cars);

            outputView.printRaceResult(car);
        }
        // outputView.printWinner();
    }
}
