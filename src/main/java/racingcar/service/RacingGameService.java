package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;

import racingcar.model.Cars;
import racingcar.model.Winners;

public class RacingGameService {
    private final Cars cars;
    private final Winners winners;
    
    public RacingGameService() {
        this.cars = new Cars();
        this.winners = new Winners();
    }
    
    public void addCars (String carNames) {
        cars.addCars(new ArrayList<String>(Arrays.asList(carNames.split(","))));
    }
}
