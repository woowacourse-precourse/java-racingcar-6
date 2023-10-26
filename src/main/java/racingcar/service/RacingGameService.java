package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;

import racingcar.model.Attemps;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class RacingGameService {
    private final Cars cars;
    private final Attemps attemps;
    private final Winners winners;
    
    public RacingGameService() {
        this.cars = new Cars();
        this.attemps = new Attemps();
        this.winners = new Winners();
    }
    
    public void addCars (String carNames) {
        // TODO: 유효성 검사
        cars.addCars(new ArrayList<String>(Arrays.asList(carNames.split(","))));
    }
    
    public void setAttemps (String numberOfAttemps) {
        // TODO: 유효성 검사
        attemps.setNumber(Integer.valueOf(numberOfAttemps));
    }
}
