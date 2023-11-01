package racingcar;

import java.util.List;

public class Game {

    private final List<Car> cars;
    public final int goal;

    public Game(List<Car> cars, int goal) {
        this.cars = cars;
        this.goal = goal;
    }


    public List<Car> getCars() {
        return cars;
    }

    public int getGoal() {
        return goal;
    }
}
