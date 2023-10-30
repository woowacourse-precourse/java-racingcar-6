package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private boolean isDuplicate() {
        int originalCarSize = this.cars.size();
        return cars.stream()
                .distinct()
                .collect(Collectors.toList())
                .size() != originalCarSize;
    }

    public void validateDuplication() {
        if(isDuplicate()) {
            throw new IllegalArgumentException("같은 자동차 이름을 입력하였습니다. 애플리케이션을 종료합니다.");
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}