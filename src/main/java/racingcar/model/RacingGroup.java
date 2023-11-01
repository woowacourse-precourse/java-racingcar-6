package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGroup {
    private List<Car> cars;
    private int chance;

    public RacingGroup() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCarToGroup(String name) {
        this.cars.add(new Car(name));
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
}
