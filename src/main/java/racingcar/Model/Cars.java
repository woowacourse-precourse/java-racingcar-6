package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String LONG_NAME = "글자 범위를 넘겼습니다.(5글자 이하)";

    public static List<String> carSplit(String carNames) {
        List<String> carList= new ArrayList<>();
        for (String carName:carNames.split(",")) {
            carList.add(carName);
            processLongNameException(carName);
        }
        return carList;
    }

    public static void processLongNameException(String carName) {
        if(carName.length()>5){
            throw new IllegalArgumentException(LONG_NAME);
        }
    }
}
