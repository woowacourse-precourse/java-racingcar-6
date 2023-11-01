package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingData;
import racingcar.view.RacingOutput;

public class Loops {

    public void loops() {

        Car car = Car.getInstance();
        RacingData racingData = RacingData.getInstance();


        RacingOutput racingOutput = new RacingOutput();
        CarMovingProcess carMovingProcess = new CarMovingProcess();


        int userSetLoopCount = racingData.getUserSetLoopTime();


        carMovingProcess.makingForwardCountList();


        for (int i = 0; i < userSetLoopCount; i++) {

            carMovingProcess.upDateForwardCountList();
            racingOutput.carRacing(racingData.getForwardPointList(),car.getPassedTestList());
        }

    }


}
