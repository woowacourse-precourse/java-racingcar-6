package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    public static void checkCarNameSize(List<String> carNames){
        int carSize = carNames.size();
        if(carSize < 1 || carSize > 8){
            throw new IllegalArgumentException("자동차 이름은 1개 이상 8개 이하여야 합니다.");
        }
    }

    public static void checkCarNameDuplication(List<String> carNames){
        List<String> carList = new ArrayList<>();
        for(String carName : carNames){
            if(carList.contains(carName)){
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }
            carList.add(carName);
        }
    }

    public static void checkCarNameIsEnglish(List<String> carNames) {
        for(String carName : carNames){
            if (!Pattern.matches("^[a-zA-Z\\s]+$", carName)) {
                throw new IllegalArgumentException("자동차 이름은 영어로만 구성되어야 합니다.");
            }
        }

    }
}
