package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carlist = new ArrayList<Car>();

    public void add(String name) {
        String cleanName = nameCleaner(name);
        nameValidator(cleanName);
        carlist.add(new Car(cleanName));
    }

    public void nameValidator(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다. 프로그램을 종료합니다.");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다. 프로그램을 종료합니다.");
        }
    }

    public String nameCleaner(String name) {
        return name.replaceAll("\\s+", "");
    }
}
