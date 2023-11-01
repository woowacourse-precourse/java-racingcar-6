package racingcar.model;

import java.util.*;

public class Cars {
    private final List<String> names = new ArrayList<>();
    private final List<Integer> scores = new ArrayList<>();

    public static Cars generateCars(String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(carName);
        }
        return cars;
    }

    public void addCar(String carName) {
        names.add(carName);
        scores.add(0);
    }

    public List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int highScore = getHighScore();
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == highScore) {
                winner.add(names.get(i));
            }
        }
        return winner;
    }

    public int getHighScore() {
        int highScore = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > highScore) {
                highScore = score;
            }
        }
        return highScore;
    }

    public List<String> getName() {
        return names;
    }

    public List<Integer> getScore() {
        return scores;
    }
}
