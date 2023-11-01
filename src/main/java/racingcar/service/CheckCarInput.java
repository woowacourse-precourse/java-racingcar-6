package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class CheckCarInput {
    public static List<String> checkCarNameInput(String inputString){
        List<String> carArray = Arrays.asList(inputString.split(","));
        for (int i = 0; i < carArray.size(); i++) {
            if(!checkValidCarNameMaxLength(carArray.get(i)) || !checkIsContainBlank(carArray.get(i))){
                throw new IllegalArgumentException();
            }
        }

        return carArray;
    }

    public static boolean checkValidCarNameMaxLength(String inputString){
        if(inputString.length() > 5){
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkIsContainBlank(String inputString){
        if(inputString == inputString.trim()) {
            return true;
        } else {
            return false;
        }
    }
}
