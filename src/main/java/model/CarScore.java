package model;

import java.util.ArrayList;
import java.util.List;

public class CarScore {
    private final List<Integer> carScore;
    public CarScore() {
        this.carScore = new ArrayList<>();
    }

    public void addCarScore(Integer score) {
        this.carScore.add(score);
    }
    public List<Integer> getCarScore() {
        return carScore;
    }
}
