package racingcar.controller;


import racingcar.model.RacingData;


public class Loops {

    CarMovingProcess carMovingProcess = new CarMovingProcess();

    public void racingLoop() {

        carMovingProcess.makingForwardCountList();

        for (int i = 0; i < RacingData.getUserSetLoopTime(); i++) {
            this.inRacingLoop();

        }
    }

    public void inRacingLoop(){

        carMovingProcess.upDateForwardCountList();
        carMovingProcess.carMovingView();
        System.out.println();

    }

}
