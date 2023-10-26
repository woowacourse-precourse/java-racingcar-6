package racingcar.model;

/**
 * 차에 대한 정보를 갖는다.
 */
public class Car {

    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
    }
}
