package model;

import java.util.ArrayList;
public class racingGameModel {
    public ArrayList<racingCarInfo> racingCarInfos;
    private int attemptCount = 0;
    public racingGameModel(int attemptCount, String[] carNamesArray) {
        this.attemptCount = attemptCount;

        racingCarInfos = new ArrayList<racingCarInfo>();
        int idx = 0;
        for(String name : carNamesArray){
            racingCarInfo carInfo = new racingCarInfo(name, idx);
            racingCarInfos.add(carInfo);
            idx++;
        }
    }
}

