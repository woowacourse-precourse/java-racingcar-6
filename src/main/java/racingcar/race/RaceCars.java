package racingcar.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import racingcar.CarName;
import racingcar.view.Input;

public class RaceCars {

    private static final String SPLIT_DELIMITER = ",";

    private final List<RaceCar> raceCarList;

    public RaceCars(Input input) {
        this.raceCarList = Collections.unmodifiableList(convertStringToList(input.readLine()));
    }

    private List<RaceCar> convertStringToList(String carNameStrings) {
        List<String> splitList = new ArrayList<>(List.of(carNameStrings.split(SPLIT_DELIMITER)));

        return splitList.stream()
                .map(name -> new RaceCar(new CarName(name)))
                .toList();
    }

    public Iterator<RaceCar> getIterator() {
        return raceCarList.iterator();
    }

    public void moveForwardEach() {
        for (RaceCar car : raceCarList) {
            car.moveForward();
        }
    }

    @Override
    public String toString() {
        return raceCarList.toString();
    }
}
