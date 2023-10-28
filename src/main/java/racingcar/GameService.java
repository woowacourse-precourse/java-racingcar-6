package racingcar;

import racingcar.domain.Cars;

public class GameService {

    private Cars cars;

    public void makeCars(String carNames){

        cars = new Cars(carNames);


    }



}
