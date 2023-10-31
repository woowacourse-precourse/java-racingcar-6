package racingcar.model;

import racingcar.util.StringUtil;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    public static final String INPUT_NAME_DUQLICATED_EXCEPTION = "중복된 이름은 입력이 불가능합니다.";
    public final List<Car> cars = new ArrayList<>();

    public Cars(String input) {
        ArrayList<String> carList = StringUtil.arrayList(input);
        validateDuplicated(carList);
        for (String name : carList) {
            cars.add(new Car(name));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.go();

        }

    }
    public List<Car> getCars() {
        return cars;
    }
    public static void validateDuplicated(ArrayList<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(INPUT_NAME_DUQLICATED_EXCEPTION);
            }
        }
    }





}
