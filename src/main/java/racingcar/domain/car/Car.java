package racingcar.domain.car;

import racingcar.domain.Generator;

public class Car {

    private static final int MOVE_BOUNDARY = 4;
    private final Generator generator;
    private final CarName name;
    private int location;

    public Car(String name, Generator generator) {
        this.name=new CarName(name);
        this.generator = generator;
        location = 0;
    }

    public void move() {
        if (isMove()) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name.getName();
    }

    private boolean isMove() {
        return MOVE_BOUNDARY <= generator.generate();
    }

}
