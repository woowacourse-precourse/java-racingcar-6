package racingcar.domain;

public class Car {
    private final Name name;
    private final Position position;

    private Car(String name, int num) {
        this.name = Name.create(name);
        this.position = Position.create(num);
    }

    public static Car from(String name, int num) {
        return new Car(name, num);
    }

    public void plusPosition() {
        position.plusNum();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getNum();
    }
}