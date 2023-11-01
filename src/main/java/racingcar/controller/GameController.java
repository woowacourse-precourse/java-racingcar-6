package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.RaceProgressView;
import racingcar.view.RaceResultView;
import racingcar.view.RaceStartView;

public class GameController {

    private RaceStartView raceStartView = new RaceStartView();
    private RaceProgressView raceProgressView = new RaceProgressView();
    private RaceResultView raceResultView = new RaceResultView();
    private final RaceService raceService = new RaceService();

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
