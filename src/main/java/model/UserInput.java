package model;

import java.util.ArrayList;
import java.util.Arrays;

public class UserInput {

    private static UserInput instance;

    private final ArrayList<String> carsName;
    private int carCount;
    private int playTime;

    private UserInput() {
        carsName = new ArrayList<>();
    }

    public static UserInput getInstance() {
        if (instance == null) {
            instance = new UserInput();
        }
        return instance;
    }

    public void setCarsName(String inputString) {
        String[] carsNameInput = inputString.replaceAll("\\s+", "").split(",");

        this.carsName.addAll(Arrays.asList(carsNameInput));
        setCarCount();
    }

    private void setCarCount() {
        this.carCount = this.carsName.size();
    }

    public void setPlayTime(int inputNum) {
        this.playTime = inputNum;
    }

    public ArrayList<String> getCarsName() {
        return carsName;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void cleanup() {
        carsName.clear();
        carCount = 0;
        playTime = 0;
    }
}
