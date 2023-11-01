package controller;

import model.GameModel;
import model.RacingCarInfo;

public class RaceStatus {
    public void printRaceStatus(GameModel racingGameModel) {
        for (RacingCarInfo carInfo : racingGameModel.racingCarInfos) {
            System.out.print(carInfo.name + " : ");
            printMoveStatus(carInfo);
        }
    }

    private void printMoveStatus(RacingCarInfo carInfo) {
        for (int count = 0; count < carInfo.moveCount; count++) {
            System.out.print("-");
        }
        System.out.println();
    }
}