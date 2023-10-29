package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingData;
import racingcar.view.RacingGameOutputs;

public class GamePlaying {

    Car car = Car.getInstance();
    RacingData racingData = RacingData.getInstance();



    TakeInputs takeInputs = new TakeInputs();

    Loops loops = new Loops();

    VictoryCondition victoryCondition = new VictoryCondition();

    DataConverter dataConverter = new DataConverter();

    ExceptionsCheck exceptionsCheck = new ExceptionsCheck();



    public void playing () {

        System.out.println(RacingGameOutputs.pleaseInuptCarNames);

        takeInputs.userInputString();
        exceptionsCheck.testInputString();

        dataConverter.changeInputStringToList(car.getPassedTestString());
        exceptionsCheck.testPassed(exceptionsCheck.testPassCountAsCar());

        System.out.println(RacingGameOutputs.inputNumberOfAttempt);

        takeInputs.userInputLoopCount();
        exceptionsCheck.testInputLoopString(exceptionsCheck.testPassCountAsLoop());

        dataConverter.changeInputStringToInteger(racingData.getUserInputLoopString());

        System.out.println();

        System.out.println(RacingGameOutputs.attemptResult);
        loops.racingLoop();

        victoryCondition.makeWinnerList();;
        victoryCondition.winnerIs(victoryCondition.winnerNumber());

    }
}
