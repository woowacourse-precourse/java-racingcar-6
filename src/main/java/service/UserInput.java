package service;

import controller.Controller;

import java.util.ArrayList;
import java.util.HashMap;

public class UserInput {

    public HashMap<String, String> carNameAndPosList;
    public ArrayList<String> carsNameList;
    public int carCount;
    public int playTime;

    public void getCarsName(String inputString) {
        String[] carsName = inputString.split(",");

        for (String name : carsName) {
            this.carNameAndPosList.put(name, "");
            this.carsNameList.add(name);
        }

        this.carCount = this.carNameAndPosList.size();
    }

    public void getPlayTime(int inputNum) {
        this.playTime = inputNum;
    }
}
