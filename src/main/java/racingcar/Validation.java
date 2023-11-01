package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class Validation {
    public static void validateCarNames(ArrayList<String> carNameList){
        carNameList.forEach((name)->{
            checkNameLength(name);
            checkNameSpace(name);
            checkNameDuplication(carNameList, name);
        });
    }
    private static void checkNameLength(String carName){
        if (carName.isEmpty() ||carName.length()>Constants.NAME_LENGTH_MAX_LIMIT){
            throw new IllegalArgumentException("name should be between 1 and 5 characters.");
        }
    }
    private static void checkNameSpace(String carName){
        if (carName.trim().isEmpty()){
            throw new IllegalArgumentException("name should not consist of only spaces");
        }
    }

    private static void checkNameDuplication(ArrayList<String> carNameList, String carName){
        int frequency =  Collections.frequency(carNameList, carName);
        if (frequency>Constants.NAME_DUPLICATION_LIMIT){
            throw new IllegalArgumentException("name should not consist of only spaces");

        }
    }
}
