package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.InputUtil;
import racingcar.view.RaceStartView;

public class GameController {

    private List<Car> carObjects;

    public void run() {
        RaceStartView raceStartView = new RaceStartView();

        String carName = raceStartView.getCarName();
        String[] carNameStrings = InputUtil.splitCarName(carName);

        String raceLap = raceStartView.getRaceLap();

        carObjects = new ArrayList<>();
        for (String carNameStr : carNameStrings) {
            carObjects.add(new Car(carNameStr));
        }
    }
}
