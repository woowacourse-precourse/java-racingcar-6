package service;

import controller.Controller;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserInput {

    public List<Map.Entry<String, String>> carIdxNamePosList = new ArrayList<>();
    public int carCount;
    public int playTime;

    public void getCarsName(String inputString) {
        String[] carsName = inputString.split(",");

        for (String name : carsName) {
            Map.Entry<String, String> newCar = new AbstractMap.SimpleEntry<>(name,"");
            this.carIdxNamePosList.add(newCar);
        }

        this.carCount = this.carIdxNamePosList.size();
    }

    public void getPlayTime(int inputNum) {
        this.playTime = inputNum;
    }
}
