package racingcar.utils;

import java.util.List;

public class Validator {

    public static void checkCarNameSize(List<String> carNames){
        int carSize = carNames.size();
        if(carSize < 1 || carSize > 8){
            throw new IllegalArgumentException("자동차 이름은 1개 이상 8개 이하여야 합니다.");
        }
    }
}
