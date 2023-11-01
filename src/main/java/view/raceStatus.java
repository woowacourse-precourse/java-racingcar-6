package view;

import model.racingCarInfo;
import model.racingGameModel;
public class raceStatus{
    public void printRaceStatus(racingGameModel racingGameModel){
        for(racingCarInfo carInfo : racingGameModel.racingCarInfos){
            System.out.print(carInfo.name+" : ");
            printMoveStatus(carInfo);
        }
    }
    private void printMoveStatus(racingCarInfo carInfo){
        for(int count=0;count<carInfo.moveCount;count++){
            System.out.print("-");
        }
        System.out.println();
    }
}