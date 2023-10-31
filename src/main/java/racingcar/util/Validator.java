package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int CAR_NAME_MIN = 1;
    private static final int CAR_NAME_MAX = 5;
    private static final int TRY_COUNT_MIN = 1;

    public void carNamesInput(String input) throws IllegalArgumentException{
        List<String> carNames = Parser.carNames(input);
        checkEachCarNameLength(carNames);
        checkCarNameDuplicate(carNames);
    }

    public void tryCountInput(String input) throws IllegalArgumentException{
        int tryCount = Parser.tryCount(input);
        checkTryCountRange(tryCount);
    }

    private void checkEachCarNameLength(List<String> carNames){
        for (String carName : carNames){
            checkCarNameEmpty(carName);
            checkCarNameLength(carName);
        }
    }

    private void checkCarNameEmpty(String carName){
        if(carName.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private void checkCarNameLength(String carName){
        if (carName.length() < CAR_NAME_MIN || carName.length() > CAR_NAME_MAX){
            throw new IllegalArgumentException();
        }
    }

    private void checkCarNameDuplicate(List<String> carNames){
        Set<String> uniqueNames = new HashSet<>();

        for(String carName : carNames){
            if(!uniqueNames.add(carName)){
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkTryCountRange(int tryCount){
        if (tryCount < TRY_COUNT_MIN){
            throw new IllegalArgumentException();
        }
    }
}
