package racingcar.domain.car;

import racingcar.domain.car.vo.CarName;

public class Car {
    private final CarName name;
    private final CarEngine engine;

    private int position;

    public Car(String name, CarEngine engine) {
        this.name = new CarName(name);
        this.engine = engine;
        this.position = 0;
    }

    public String getName() {
        return name.name();
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if(engine.move()) {
            position++;
        }
    }

}
