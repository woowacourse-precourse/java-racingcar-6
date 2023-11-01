package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Const.*;
public class Exception {

    public static List<String> duplicationCheckName= new ArrayList<>();

    public static void checkCarNames(String carNames) {
        duplicationCheckName.clear();
        String[] carNameArray = carNames.split(",");

        for(String carName : carNameArray){
            checkCarNameIsEmpty(carName);
            checkCarNameIncludeGap(carName);
            checkCarNameLength(carName);
            checkCarNamesDuplication(carName);
        }
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CARNAMES_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH_OVER_EXECPTION_MESSAGE);
        }
    }

    private static void checkCarNameIncludeGap(String carName) {
        if(carName.contains(" ")) {
            throw new IllegalArgumentException(NAME_INCLUDE_GAP_EXCEPTION_MESSAGE);
        }
    }

    private static void checkCarNameIsEmpty(String carName) {
        if(carName.isEmpty()){
            throw new IllegalArgumentException(NOTHING_INPUT_CAR_NAMES_EXCEPTION_MESSAGE);
        }
    }


    public static void checkCarNamesDuplication(String carName) {
        if(duplicationCheckName.contains(carName)){
            throw new IllegalArgumentException(NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
        duplicationCheckName.add(carName);
    }

    public static void checkTryCount(String userTryCount){
        checkTryCountIsEmpty(userTryCount);
        int gameTryCount = checkTryCountIsNumber(userTryCount);
        checkTryCountIsNagative(gameTryCount);
    }

    public static void checkTryCountIsEmpty(String userTryCount) {
        if (userTryCount.isEmpty()) {
            throw new IllegalArgumentException(USER_INPUT_COUNT_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    public static void checkTryCountIsNagative(int gameTryCount) {
        if (gameTryCount <= 0){
            throw new IllegalArgumentException(USER_INPUT_COUNT_NEGATIVE_EXCEPTION_MESSAGE);
        }
    }

    public static int checkTryCountIsNumber(String userTryCount){
        try{
            return Integer.parseInt(userTryCount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_COUNT_NOT_NUMBER);
        }



    }

}
