package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validation {

    public static List<String> validateCarNames(String cars){
        List<String> carsStingList = validateDivision(cars);
        validateLength(carsStingList);
        return carsStingList;
    }
    private static List<String> validateDivision(String cars){
        List<String> carsStingList = new ArrayList<>();
        String[] carInputList = cars.split(",");
        carsStingList.addAll(Arrays.asList(carInputList));
        return carsStingList;
    }

    private static void validateLength(List<String> carsStingList){

    }
}
