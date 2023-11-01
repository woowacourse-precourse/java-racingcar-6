package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Model.RacingData;
import racingcar.View.RacingOutput;

public class Loops {

    public void loops() {

        Car car = Car.getInstance();
        RacingData racingData = RacingData.getInstance();


        RacingOutput racingOutput = new RacingOutput();
        CarMovingProcess carMovingProcess = new CarMovingProcess();


        int userSetLoopCount = racingData.getUserSetLoopTime();


        carMovingProcess.makingForwardCountList(car.getPassedTestList());


        for (int i = 0; i < userSetLoopCount; i++) {

            carMovingProcess.upDateForwardCountList(racingData.getForwardPointList());
            racingOutput.carRacing(racingData.getForwardPointList(),car.getPassedTestList());
        }

    }


}
