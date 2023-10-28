package service;

import view.View;

import java.util.LinkedHashMap;

public class UserInput {

    public static View view = new View();
    public LinkedHashMap<String, String> carNameAndPosList;
    public int playTime;
    public int carCount;

    public void getCarsName() {
        String userInput = view.requestCarsName();
        String[] carsName = userInput.split(",");

        for(String name : carsName) {
            carNameAndPosList.put(name, "");
        }
    }

    public void getPlayTime() {

    }
}
