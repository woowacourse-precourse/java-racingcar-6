package racingcar.model;

import java.util.ArrayList;

public class Car {
    private static final String ONE_STEP = "-";
    private final String carName;
    private int raceLength;
    private StringBuilder stepDistance;

    public Car(String carName) {
        this.carName = carName;
        this.raceLength = 0;
        this.stepDistance = new StringBuilder();
    }

    public int getRaceLength() {
        return raceLength;
    }

    public void plusOneStep(){
        raceLength+=1;
        stepDistance.append(ONE_STEP);
    }

    public String getCarName(){
        return carName;
    }

    public String getStepDistence(){
        return stepDistance.toString();
    }

    public String totalDistance(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<raceLength;i++){
            sb.append(ONE_STEP);
        }

        return sb.toString();
    }
}
