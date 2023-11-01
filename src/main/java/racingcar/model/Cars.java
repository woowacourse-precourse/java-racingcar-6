package racingcar.model;

import java.util.*;

public class Cars {
    private final Map<String, Integer> state = new HashMap<>();

    public static Cars generateCars(String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(carName);
        }
        return cars;
    }

    public void addCar(String carName) {
        state.put(carName, 0);
    }

    public List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int highScore = getHighScore();

        for (Map.Entry<String, Integer> entry : state.entrySet()) {
            String name = entry.getKey();
            Integer score = entry.getValue();
            if (score.equals(highScore)) {
                winner.add(name);
            }
        }
        Collections.sort(winner);
        return winner;
    }

    public int getHighScore() {
        int highScore = Integer.MIN_VALUE;
        for (int score : state.values()) {
            if (score > highScore) {
                highScore = score;
            }
        }
        return highScore;
    }

    public Map<String, Integer> getState() {
        return state;
    }

    public List<String> getName() {
        List<String> carNames = new ArrayList<>(state.keySet());
        Collections.sort(carNames);
        return carNames;
    }

    public int getScore(String name) {
        return state.get(name);
    }
}
