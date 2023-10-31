package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class UserInput {

    private final static UserInput instance = new UserInput();

    private UserInput() {
    }

    public static UserInput getInstance() {
        return instance;
    }

    private final ArrayList<String> carsName = new ArrayList<>();
    private int carCount;
    private int playTime;

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
