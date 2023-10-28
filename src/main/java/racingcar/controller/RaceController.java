package racingcar.controller;

import racingcar.model.CarRace;
import racingcar.model.Cars;
import racingcar.view.RaceViewer;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final CarRace carRace = new CarRace();
    private final RaceViewer viewer = new RaceViewer();

    public RaceController() {}

    public void start() {
        List<String> stringCars = new ArrayList<>();
        stringCars.add("jiyun");
        stringCars.add("user2");
        Cars cars = new Cars(stringCars);

        for (int i=0;i<5;i++) {
            carRace.playOneTurn(cars);
            viewer.showCarsStep(cars);
            System.out.println();
        }
    }
}
