package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Model.RacingData;
import racingcar.View.WinnerOutput;

import java.util.List;

public class WinnerController {
    public void winners() {

        Car car = Car.getInstance();
        RacingData racingData = RacingData.getInstance();


        VictoryCondition victory = new VictoryCondition();
        WinnerOutput winnerOutput = new WinnerOutput();


        int mostFar = victory.mostFarDistance(racingData.getForwardPointList());
        int winnerNum =victory.winnerNumber();
        List<String> winnerList= victory.makeWinnerList(car.getPassedTestList(),racingData.getForwardPointList(),mostFar);


        winnerOutput.winnerOutputs(winnerList, winnerNum);

    }
}
