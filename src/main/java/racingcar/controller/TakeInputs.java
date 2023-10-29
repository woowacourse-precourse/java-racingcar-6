package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RacingData;

public class TakeInputs {

    Car car = Car.getInstance();
    RacingData racingData = RacingData.getInstance();

    public void userInputString(){

        String carNamesString = Console.readLine();
        car.setUserInputString(carNamesString);

    }

    public void userInputLoopCount(){

       String loopTime =Console.readLine();
       racingData.setUserInputLoopString(loopTime);

    }


}
