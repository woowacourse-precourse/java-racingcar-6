package racingcar.model;

import java.util.ArrayList;

public class Car {
    private static final String ONE_STEP = "-";
    private final String carName;
    private boolean isWinner;
    private int raceLength;

    public Car(String carName) {
        this.carName = carName;
        this.isWinner = false;
        this.raceLength = 0;
    }

    public int getRaceLength() {
        return raceLength;
    }

    public void plusOneStep(){
        raceLength+=1;
    }

    public String getCarName(){
        return carName;
    }

    public String totalDistance(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<raceLength;i++){
            sb.append(ONE_STEP);
        }

        return sb.toString();
    }
}
