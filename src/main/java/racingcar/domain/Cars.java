package racingcar.domain;

import java.util.ArrayList;

public class Cars {
    ArrayList<String> CarNames;
    int CarCount;
    int RaceCount;

    public Cars() {
    }

    public void setRaceCount(int raceCount){
        this.RaceCount = raceCount;
    }

    public int getRaceCount(){
        return RaceCount;
    }

    public int[] initNumber(int[] carRandomnumbers, int carCount){
        carRandomnumbers = new int[carCount];
        return carRandomnumbers;
    }

    public ArrayList<String> getCarNames(){
        return CarNames;
    }

    public void setCarNames(ArrayList<String> carnames){
        this.CarNames = carnames;
    }


}
