package racingcar.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarInputValidate {
    public static void carDuplicateCheck(String[] carNames){
        if(Arrays.stream(carNames)
                .distinct()
                .count() != carNames.length){
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");

        }
    }

    public static void carNameLengthValidate(String carName) {
        carNameOverFiveLength(carName);
        carNameUnderOneLength(carName);
    }

    private static void carNameUnderOneLength(String carName){
        if(carName == null || carName.trim().isEmpty()){
            throw new IllegalArgumentException("자동차의 이름이 비어있거나 공백문자입니다.");
        }
    }

    private static void carNameOverFiveLength(String carName){
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
    }
}
