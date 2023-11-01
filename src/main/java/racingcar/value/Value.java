package racingcar.value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Value {
    public List<String> carNames;
    int numberOfAttempts;
    private final List<String> winners;
    private final List<Integer> carPositions;

    public Value() {
        this.carNames = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.carPositions = new ArrayList<>();
    }

    public void addCarNames(String[] names) {
        carNames.addAll(Arrays.asList(names));
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void initializeCarPositions(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            carPositions.add(0);
        }
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }

    public void updateCarPositions(int carIndex, int newPosition) {
        carPositions.set(carIndex, newPosition);
    }


    private int findMaxPosition() {
        int max = 0;
        for (int position : carPositions) {
            max = Math.max(max, position);
        }
        return max;
    }

    public void determineWinners() {
        int maxPosition = findMaxPosition();
        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions.get(i) == maxPosition) {
                winners.add(carNames.get(i));
            }
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
