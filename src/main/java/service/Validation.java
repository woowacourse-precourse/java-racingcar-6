package service;

import static util.ErrorMessage.CAR_COUNT_ERROR;
import static util.ErrorMessage.CAR_NAME_COMMA_ERROR;
import static util.ErrorMessage.CAR_NAME_DUPLICATE_ERROR;
import static util.ErrorMessage.CAR_NAME_SIZE_ERROR;
import static util.ErrorMessage.CAR_NAME_SPACE_ERROR;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private static final int MAX_NAME_SIZE = 5;
    private static final Pattern timesPattern = Pattern.compile("^[1-9][0-9]*$");
    private static final Pattern spacePattern = Pattern.compile("^\\s*$");
    private static final Pattern commaPattern = Pattern.compile(".*,.*");
    public static void CheckCarNames(List<String> carNames){
        CheckDuplicate(carNames);
        CheckNameCount(carNames);
        carNames.forEach(car -> {
            CheckLength(car);
            CheckSpace(car);
            CheckComma(car);
        });

    }

    public static void CheckNameCount(List<String> carNames) {
        if(carNames.size() == 1){
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }
    }

    public static void CheckDuplicate(List<String> carNames){
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR);
        };
    }

    public static void CheckLength(String carName){
        if(carName.isEmpty() || carName.length()>MAX_NAME_SIZE){
            throw new IllegalArgumentException(CAR_NAME_SIZE_ERROR);
        }
    }

    public static void CheckSpace(String carName){
        if(spacePattern.matcher(carName).matches()){
            throw new IllegalArgumentException(CAR_NAME_SPACE_ERROR);
        }
    }

    public static void CheckComma(String carName){
        if(commaPattern.matcher(carName).matches()){
            throw new IllegalArgumentException(CAR_NAME_COMMA_ERROR);
        }
    }

    public static void CheckTimes(String times){
        if(!timesPattern.matcher(times).matches()){
            throw new IllegalArgumentException();
        }
    }
}
