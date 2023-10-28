package service;

import view.View;

import java.util.LinkedHashMap;

public class UserInput {

    public static View view = new View();
    public static LinkedHashMap<String, String> carNameAndPosList;
    public static int carCount;
    public static int playTime;

    public void getCarsName() {
        String userInput = view.requestCarsName();
        String[] carsName = userInput.split(",");

        for (String name : carsName) {
            carNameAndPosList.put(name, "");
        }

        carCount = carNameAndPosList.size();
    }

    public void getPlayTime() {
        int userInput = view.requestPlayTime();

        playTime = userInput;
    }
}
