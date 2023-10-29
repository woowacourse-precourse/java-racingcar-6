package racingcar.model;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarName {
    // 사용자가 입력한 자동차 이름을 쉼표(,)로 구분하여 리스트로 반환
    public List<Car> splitUserInputCarName(String userInput) {
        String[] names = userInput.split(",");

        List<Car> carList = new ArrayList<>();
        for(String name : names) {
            carList.add(new Car(name));
        }

        return carList;
    }
}
