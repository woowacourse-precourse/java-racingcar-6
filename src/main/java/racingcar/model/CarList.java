package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carlist = new ArrayList<Car>();

    public void add(String name) {
        nameValidator(name);
        carlist.add(new Car(name));
    }

    public void nameValidator(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다. 프로그램을 종료합니다.");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다. 프로그램을 종료합니다.");
        }
    }
}
