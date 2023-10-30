package racingcar;

import java.util.List;

public class Validation {

    public static List<String> validateCarNames(String cars){
        List<String> carsStingList = validateDivision(cars);
        validateLength(carsStingList);
        return carsStingList;
    }
    private static List<String> validateDivision(String cars){
        return null;
    }

    private static void validateLength(List<String> carsStingList){

    }
}
