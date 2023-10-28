package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.dto.CarRecord;
import racingcar.domain.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private Cars cars;

    public void makeCars(String carNames){
        cars = new Cars(carNames);
    }

    public RoundResult forward(){

        cars.moveForward();

        return new RoundResult(cars.saveRecord());
    }




}
