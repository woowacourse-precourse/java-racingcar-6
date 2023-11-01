package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataConverter {
    Car car = Car.getInstance();
    RacingData racingData = RacingData.getInstance();

    public List changeInputStringToList (String userInputCarString) {

        List<String> changeStringToList = new ArrayList<>();
        StringTokenizer carListElements = new StringTokenizer(userInputCarString, ",");

        while (carListElements.hasMoreTokens()) {
            changeStringToList.add(carListElements.nextToken());
        }

        car.setStringToList(changeStringToList);

        return changeStringToList;
    }

    public int changeInputStringToInteger (String userInputLoopCount) {

        racingData.setUserSetLoopTime(Integer.parseInt(userInputLoopCount));
        return Integer.parseInt(userInputLoopCount);
    }

}

