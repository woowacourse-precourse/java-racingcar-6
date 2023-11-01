package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Car {

    public boolean isCarMovingForward(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4){
            return true;
        }
        return false;
    }

    public Map<String, String> getCarNameInfoMap(String allCarNames){
        Map<String, String> carNamesHashTable = new Hashtable<>();
        String[] splitCarNames = splitCarNames(allCarNames);

        for (String carName : splitCarNames) {
            carNamesHashTable.put(carName, "");
        }

        return carNamesHashTable;
    }

    public int countDistance(String distance){

        int sumDistance=  (int) distance.chars().filter(c -> equals("-")).count();

        return sumDistance;

    }

    private static String[] splitCarNames(String allCarNames){
        String[] carNamesArray = allCarNames.split(",");
        return carNamesArray;
    }


}
