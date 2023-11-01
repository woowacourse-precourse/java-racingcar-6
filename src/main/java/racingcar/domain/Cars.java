package racingcar.domain;

import java.util.ArrayList;

public class Cars {
    ArrayList<String> CarNames;
    int RaceCount;

    public Cars() {
    }

    public void setRaceCount(int raceCount){
        this.RaceCount = raceCount;
    }

    public int getRaceCount(){
        return RaceCount;
    }

    public ArrayList<String> getCarNames(){
        return CarNames;
    }

    public void setCarNames(ArrayList<String> carnames){
        this.CarNames = carnames;
    }

}
