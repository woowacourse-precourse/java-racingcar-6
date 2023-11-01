package racingcar.controller;

import racingcar.model.*;
import racingcar.view.RacingGameDescription;

public class GamePlaying {

    RacingData racingData= RacingData.getInstance();
    Car car = Car.getInstance();



    DataConverter dataConverter = new DataConverter();
    TakeInputs takeInputs = new TakeInputs();
    Loops dataCarrier = new Loops();
    ExceptionsCheck exceptionsCheck = new ExceptionsCheck();
    WinnerController winner = new WinnerController();


    public void playing (){

        System.out.println(RacingGameDescription.pleaseInuptCarNames);


        takeInputs.userInputCarString();
        exceptionsCheck.testInputString();


        dataConverter.changeInputStringToList(car.getPassedTestString());
        exceptionsCheck.passedCheckCarList();


        System.out.println(RacingGameDescription.inputNumberOfAttempt);


        takeInputs.userInputLoopCount();
        exceptionsCheck.passedCheckLoopString();


        dataConverter.changeInputStringToInteger(racingData.getPassedTestLoopString());


        System.out.println();
        System.out.println(RacingGameDescription.attemptResult);


        dataCarrier.loops();

        winner.winners();

    }

}

