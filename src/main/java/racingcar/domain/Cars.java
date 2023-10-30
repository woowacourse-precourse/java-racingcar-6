package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public void init(String[] carArr) {
        for (String carName : carArr) {
            carList.add(Car.from(carName, 0));
        }
        validateDuplicateName();
    }

    private void validateDuplicateName() {
        Set<String> carSet = new HashSet<>();
        for (Car car : carList) {
            String name = car.getName();
            if (carSet.contains(name)) {
                throw new IllegalArgumentException("중복되는 이름이 있습니다.");
            }
            carSet.add(car.getName());
        }
    }

    public int size() {
        return carList.size();
    }

    public void plusNum(int i) {
        carList.get(i).plusPosition();
    }

    public String getName(int i) {
        return carList.get(i).getName();
    }

    public int getGameNum(int i) {
        return carList.get(i).getPosition();
    }

    public int findMaxPosition() {
        int max = 0;
        for (Car car : carList) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }
}