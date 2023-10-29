package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingData;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataConverter {

    RacingData racingData = RacingData.getInstance();
    Car car = Car.getInstance();

    public void changeInputStringToList (String passedTestString) {

        List<String> changeStringToList = new ArrayList<>();
        StringTokenizer carListElements = new StringTokenizer(car.getPassedTestString(), ",");

        while (carListElements.hasMoreTokens()) {
            changeStringToList.add(carListElements.nextToken());
        }

        car.setStringToList(changeStringToList);
    }

    public void changeInputStringToInteger (String passedTestLoopString) {

        passedTestLoopString = racingData.getPassedTestLoopString();

        int changeStringToInt = Integer.parseInt(passedTestLoopString);

        racingData.setUserSetLoopTime(changeStringToInt);
    }


}

