package service;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private static final int MAX_NAME_SIZE = 5;
    private static final Pattern timesPattern = Pattern.compile("^[1-9][0-9]*$");
    private static final Pattern spaceOrCommasPattern = Pattern.compile("^[,\\s]*$");
    public static void CheckCarNames(List<String> carNames){
        CheckDuplicate(carNames);
        CheckNameCount(carNames);
        carNames.forEach(car -> {
            CheckLength(car);
            CheckSpaceOrCommas(car);
        });

    }

    private static void CheckNameCount(List<String> carNames) {
        if(carNames.size() == 1){
            throw new IllegalArgumentException();
        }
    }

    public static void CheckDuplicate(List<String> carNames){
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException();
        };
    }

    public static void CheckLength(String carName){
        if(carName.isEmpty() || carName.length()>MAX_NAME_SIZE){
            throw new IllegalArgumentException();
        }
    }

    public static void CheckSpaceOrCommas(String carName){
        if(spaceOrCommasPattern.matcher(carName).matches()){
            throw new IllegalArgumentException();
        }
    }

    public static void CheckTimes(String times){
        if(!timesPattern.matcher(times).matches()){
            throw new IllegalArgumentException();
        }
    }
}
