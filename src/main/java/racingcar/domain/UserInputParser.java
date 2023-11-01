package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class UserInputParser {
    public int parseInt(String userInput) {
        int result = 0;

        try {
            result = Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        return result;
    }

    public List<Car> generateCarList(String userInput) {
        String[] tempCarList = userInput.split(",");

        List<Car> carList = new ArrayList<>();

        for (String carName : tempCarList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("차량 이름은 5글자 이하이어야 합니다.");
            }
            carList.add(new Car(carName, 0));
        }

        return carList;
    }
}
