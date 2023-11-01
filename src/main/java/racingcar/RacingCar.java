package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingCar {
    public boolean carMoveForward(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        if(randomNum >= 4){
            return true;
        }

        return false;
    }

    public Map<String, String> getCarName(String carNames){
        Map<String, String> carNameHashMap = new HashMap<>();
        String[] splitCarNames = splitCarNames(carNames);

        for(String carName : splitCarNames){
            carNameHashMap.put(carName, "");
        }

        return carNameHashMap;
    }

    public int countDistance(String distance){
        int totalDistance=  (int) distance.chars().filter(c -> equals("-")).count();
        return totalDistance;
    }

    private static String[] splitCarNames(String carNames){
        String[] carNamesArray = carNames.split(",");
        return carNamesArray;
    }

}