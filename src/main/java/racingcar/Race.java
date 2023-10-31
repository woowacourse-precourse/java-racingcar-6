package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> participatingCars;
    private int moveCounts;

    public Race() {
        participatingCars = new ArrayList<>();
    }

    public void registerCar(List<String> participatingCars) {
        // 검증 추가 필요
        for (String carName : participatingCars) {
            this.participatingCars.add(new Car(carName));
        }
    }
}