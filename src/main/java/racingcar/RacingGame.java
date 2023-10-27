package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    public RacingGame(){
    }

    public void startRacingProcess(){
        String carsName = GameInput.inputCarsName();
        CarCollection cars = new CarCollection(carsName);
    }

}
