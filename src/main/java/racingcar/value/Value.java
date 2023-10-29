package racingcar.value;

import java.util.ArrayList;
import java.util.List;


public class Value {
    public List<String> carNames;
    int numberOfAttempts;
    private List<String> winners;
    private List<Integer> carPositions;

    public Value() {
        this.carNames = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.carPositions = new ArrayList<>();
    }

    public void addCarNames(String[] names) {
        for (String name : names) {
            carNames.add(name);
        }
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


    public void determineWinners(List<Integer> carPositions) {
        int maxPosition = findMaxPosition(carPositions);
        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions.get(i) == maxPosition) {
                winners.add(carNames.get(i));
            }
        }
    }

    private int findMaxPosition(List<Integer> carPositions) {
        int max = 0;
        for (int position : carPositions) {
            max = Math.max(max, position);
        }
        return max;
    }

    public List<String> getWinners() {
        return winners;
    }
}
