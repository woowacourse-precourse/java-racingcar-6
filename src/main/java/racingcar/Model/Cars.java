package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String LONG_NAME = "글자 범위를 넘겼습니다.(5글자 이하)";
    private static final String NAME_IS_NULL = "입력된 이름이 없습니다.";
    private static final String COMMA_IN_NAME = "쉼표는 이름에 들어갈 수 없습니다.";


    public static List<String> split(String carNames) {
        List<String> carList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            carList.add(carName);
            nameValidation(carName);
        }
        return carList;
    }

    public static void nameValidation(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(LONG_NAME);
        }
        if (carName.equals("")) {
            throw new IllegalArgumentException(NAME_IS_NULL);
        }
        if (carName.contains(",")) {
            throw new IllegalArgumentException(COMMA_IN_NAME);
        }
    }
}
