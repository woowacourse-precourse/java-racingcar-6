package racingcar.Service;

import java.util.ArrayList;
import java.util.List;

public class CarName {
    private static final String LONG_NAME = "글자 범위를 넘겼습니다.(5글자 이하)";
    private static final String NAME_IS_NULL = "입력된 이름이 없습니다.";
    private static final String DELIMITER_IN_NAME = ",는 이름에 들어갈 수 없습니다.";
    private static final String DELIMITER = ",";
    private static List<String> carList = new ArrayList<>();


    public static List<String> split(String carNames) {
        for (String carName : carNames.split(DELIMITER)) {
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
            throw new IllegalArgumentException(DELIMITER_IN_NAME);
        }
    }
}
