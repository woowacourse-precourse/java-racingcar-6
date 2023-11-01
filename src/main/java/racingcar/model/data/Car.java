package racingcar.model.data;

import static racingcar.util.GameConstants.STANDARD_MOVEMENT;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import racingcar.model.record.Name;

public class Car {
    private Name name;
    private Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void moveOrNot(int value) {
        if (value >= STANDARD_MOVEMENT) {
            position.forward();
        }
    }

    public Map.Entry<String, Integer> getStatus() {
        return new SimpleEntry<>(this.name.name(), position.position);
    }
}
