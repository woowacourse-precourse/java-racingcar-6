package racingcar.model;

public class Car {

    private Name name;
    private Distance distance;

    public Car(Name name) {

        if (name == null) {
            throw new IllegalArgumentException("이름은 null일 수 없습니다.");
        }

        this.name = name;
        this.distance = new Distance();
    }

    public String getMyName() {
        return name.toString();
    }
}
