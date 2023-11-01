package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarStatus;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private List<Car> racingCarList;

    private RacingGameService(final String inputNameString) {

    }

    public static RacingGameService make(final String inputNameString) {
        return new RacingGameService(inputNameString);
    }

    public List<CarStatus> play() {
        return new ArrayList<>();
    }

    public List<String> determineRaceWinners() {
        return new ArrayList<>();
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }
}
