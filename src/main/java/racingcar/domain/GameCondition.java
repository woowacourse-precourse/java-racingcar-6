package racingcar.domain;

import java.util.HashMap;
import java.util.List;

public class GameCondition {
    private Cars cars;
    private RandomChance randomChance;

    public GameCondition(List<String> names) {
        this.cars = new Cars(names);
        this.randomChance = new RandomChance();
    }

    public void race() {
        cars.moveCar(randomChance);
    } 

    public Racing racing() {
        HashMap<String, Integer> score = new HashMap<>();
        for (Car car : cars.getCars()) {
            score.put(car.getName(), car.getPosition());
        }
        return new Racing(score);
    }

}
