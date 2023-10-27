package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class ValidInput {

    public static void validCarNameLength(String carNames){
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        for (String carName : carNameList) {
            if(carName.length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validOnlyNumber(String input){
        String reg = "^[0-9]*$";
        if(!input.matches(reg)){
            throw new IllegalArgumentException();
        }
    }
}
