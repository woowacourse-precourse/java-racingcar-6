package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.InputUtil;
import racingcar.service.RaceService;
import racingcar.view.RaceResultView;
import racingcar.view.RaceStartView;

public class GameController {

    public void run() {
        RaceStartView raceStartView = new RaceStartView();

        String carName = raceStartView.getCarName();
        String[] carNameStrings = InputUtil.splitCarName(carName);

        String raceLap = raceStartView.getRaceLap();

        List<Car> carObjects = new ArrayList<>();
        for (String carNameStr : carNameStrings) {
            carObjects.add(new Car(carNameStr));
        }

        int lap = InputUtil.getRaceLap(raceLap);

        RaceService raceService = new RaceService();
        String result = raceService.startRace(carObjects, lap);

        RaceResultView.printRaceResult(result);
    }
}
