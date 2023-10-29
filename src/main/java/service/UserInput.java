package service;

import java.util.ArrayList;
import java.util.Arrays;

public class UserInput {

    public ArrayList<String> carsName = new ArrayList<>();
    public int carCount;
    public int playTime;

    public void getCarsName(String inputString) {
        String[] carsNameInput = inputString.split(",");

        this.carsName.addAll(Arrays.asList(carsNameInput));
        this.carCount = this.carsName.size();
    }

    public void getPlayTime(int inputNum) {
        this.playTime = inputNum;
    }
}
