package racingcar.domain.car;

import racingcar.domain.car.vo.CarName;
import racingcar.domain.car.vo.CarPosition;

public class Car {
    private final CarName name;
    private final CarEngine engine;
    private final CarPosition position;

    public Car(String name, CarEngine engine) {
        this.name = new CarName(name);
        this.engine = engine;
        this.position = new CarPosition();
    }

    public String getName() {
        return name.name();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move() {
        if (engine.move()) {
            position.move();
        }
    }
}
