package racingcar.domain.car;

public class Car {
    private final String name;
    private final CarEngine engine;

    private int position;

    public Car(String name, CarEngine engine) {
        validateName(name);
        this.name = name;
        this.engine = engine;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
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
