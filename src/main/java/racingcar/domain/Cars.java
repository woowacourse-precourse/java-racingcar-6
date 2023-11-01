package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final List<Car> carList = new ArrayList<>();

    public void init(String[] carArr) {
        carList.clear();
        for (String carName : carArr) {
            carList.add(Car.from(carName, 0));
        }
        validateDuplicateName();
    }

    private Cars() {
    }

    public static Cars create() {
        return new Cars();
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

    public void plusNum(int i, int random) {
        getCar(i).plusPosition(random);
    }

    public String getName(int i) {
        return getCar(i).getName();
    }

    public int getPosition(int i) {
        return getCar(i).getPosition();
    }

    private Car getCar(int i) {
        return carList.get(i);
    }

    public int findMaxPosition() {
        int max = 0;
        for (Car car : carList) {
            max = car.findMaxPosition(max);
        }
        return max;
    }
}