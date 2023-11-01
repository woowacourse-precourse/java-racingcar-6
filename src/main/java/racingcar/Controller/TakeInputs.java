package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Car;
import racingcar.Model.RacingData;

public class TakeInputs {

    Car car = Car.getInstance();
    RacingData racingData = RacingData.getInstance();

    public String userInputCarString(){

        String carNamesString = Console.readLine();
        car.setUserInputString(carNamesString);

        return carNamesString;
    }

    public String userInputLoopCount(){

        String loopTime =Console.readLine();
        racingData.setUserInputLoopString(loopTime);

        return loopTime;
    }

}
