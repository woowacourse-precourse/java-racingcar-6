package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputCarName {

    public List<String> inputCar(String carNames) {

        try {
            if (carNames.isEmpty()) {
                throw new IllegalArgumentException("입력한 값이 없습니다.");
            }

            List<String> carNameList = Arrays.asList(carNames.split(","));

            for (String name : carNameList) {
                System.out.println(name);
                if (name.length() > 5) {
                    throw new IllegalArgumentException("6자 이상의 값을 입력하였습니다.");
                }
            }

            return carNameList;

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
