package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceCars {

    private final List<RaceCar> raceCarList;

    public RaceCars(List<RaceCar> raceCarList) {
        this.raceCarList = Collections.unmodifiableList(raceCarList);
    }

    public RaceCars(String carNameStrings) {
        this.raceCarList = Collections.unmodifiableList(convertStringToList(carNameStrings));
    }

    private List<RaceCar> convertStringToList(String carNameStrings) {
        List<String> splitList = new ArrayList<>(List.of(carNameStrings.split(",")));

        return splitList.stream()
                .map(name -> new RaceCar(new CarName(name)))
                .toList();
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

    @Override
    public String toString() {
        return "raceCarList=" + raceCarList;
    }
}
