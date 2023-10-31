package racingcar.domain;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

/* 최종 우승자 추출 클래스
* */
public class Winner {
    private Cars cars;
    public Winner( Cars cars) {
        this.cars = cars;
    }

    public int maxLocation() {
        return this.cars.cars.stream()
                .mapToInt(car -> car.location)
                .max()
                .orElse(-1);
    }
}
