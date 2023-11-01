package model;

import static model.utilityModel.getRandomNumber;

import java.util.ArrayList;
public class racingGameModel {
    public ArrayList<racingCarInfo> racingCarInfos;
    public racingGameModel(String[] carNamesArray) {
        racingCarInfos = new ArrayList<racingCarInfo>();
        int idx = 0;
        for(String name : carNamesArray){
            racingCarInfo carInfo = new racingCarInfo(name, idx);
            racingCarInfos.add(carInfo);
            idx++;
        }
    }

    public void updateRaceStatus(){
        for(racingCarInfo carInfo : racingCarInfos){
            int randomNumber = getRandomNumber();
            if(randomNumber >= 4){
                carInfo.moveCount+=1;
            }
        }
    }
}

