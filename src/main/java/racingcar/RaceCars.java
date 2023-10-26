package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceCars {

    private final List<RaceCar> raceCarList;

    public RaceCars(List<RaceCar> raceCarList) {
        this.raceCarList = Collections.unmodifiableList(raceCarList);
    }

    public List<RaceCar> getMaximumList() {
        List<RaceCar> maximumList = new ArrayList<>();
        RaceCar firstCar = raceCarList.get(0);

        for (RaceCar raceCar : raceCarList) {
            if (firstCar.compareTo(raceCar) == 0) {
                maximumList.add(raceCar);
                continue;
            }
            if (firstCar.compareTo(raceCar) == -1) {
                maximumList.clear();
                firstCar = raceCar;
                maximumList.add(raceCar);
            }
        }

        return maximumList;
    }
}
