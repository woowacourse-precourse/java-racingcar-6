package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    public static List<Car> createCarList() {
        // 여기서 setcarname으로 String List로 가져온 후 Car List 만들어 반환
        List<Car> CarList = new ArrayList<Car>();
        List<String> CarNames = UserInput.getCarNames();
        for (String name : CarNames) {
            CarList.add(new Car(name));
        }
        // CarNames 리스트에서 하나씩 꺼내 Car 객체 생성 및 리스트화
        return CarList;
    }
}
