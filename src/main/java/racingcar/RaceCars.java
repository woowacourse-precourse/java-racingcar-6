package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.MoveProbability;
import racingcar.domain.RandomNumberGenerator;

public class RaceCars {

    private static final int EQUAL = 0;
    private static final int LESS_THAN = -1;
    private static final int FIRST_ELEMENT_INDEX = 0;
    private static final String SPLIT_DELIMITER = ",";

    private final List<RaceCar> raceCarList;

    public RaceCars(List<RaceCar> raceCarList) {
        this.raceCarList = Collections.unmodifiableList(raceCarList);
    }

    public RaceCars(String carNameStrings) {
        this.raceCarList = Collections.unmodifiableList(convertStringToList(carNameStrings));
    }

    private List<RaceCar> convertStringToList(String carNameStrings) {
        List<String> splitList = new ArrayList<>(List.of(carNameStrings.split(SPLIT_DELIMITER)));

        return splitList.stream()
                .map(name -> new RaceCar(new CarName(name)))
                .toList();
    }

    public void printAllCar() {
        for (RaceCar car : raceCarList) {
            car.printCurrentPositions();
        }
        System.out.println();
    }

    public void moveForwardEach() {
        for (RaceCar car : raceCarList) {
            if (canMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean canMoveForward() {
        MoveProbability probability = MoveProbability.getInstance(new RandomNumberGenerator());
        return probability.canMoveForward();
    }

    public List<RaceCar> getMaximumList() {
        List<RaceCar> maximumList = new ArrayList<>();
        RaceCar firstCar = raceCarList.get(FIRST_ELEMENT_INDEX);

        for (RaceCar raceCar : raceCarList) {
            if (firstCar.compareTo(raceCar) == EQUAL) {
                maximumList.add(raceCar);
                continue;
            }
            if (firstCar.compareTo(raceCar) == LESS_THAN) {
                maximumList.clear();
                firstCar = raceCar;
                maximumList.add(raceCar);
            }
        }

        return maximumList;
    }

    @Override
    public String toString() {
        return raceCarList.toString();
    }
}
