package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> carList = new ArrayList<>();
    private final List<String> carNameList;
    private final int tryCount;

    public Race(List<String> carNameList, int tryCount) {
        this.carNameList = carNameList;
        this.tryCount = tryCount;
    }

    public void start() {
        setCarInstance();
        tryNRound(tryCount);
    }

    private void setCarInstance() {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    private void tryNRound(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            tryOneRound();
        }
    }

    private void tryOneRound() {
        for (Car car : carList) {
            car.goOrStop();
            car.printNameAndCount();
        }
    }
}
