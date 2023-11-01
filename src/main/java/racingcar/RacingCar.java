package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

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
        return (int) distance.chars().filter(c -> c== '-').count();
    }

    private static String[] splitCarNames(String carNames){
        String[] carNamesArray = carNames.split(",");
        return carNamesArray;
    }

}