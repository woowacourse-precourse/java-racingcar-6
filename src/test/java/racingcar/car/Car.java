package racingcar.car;

public class Car {
    private String name;

    public Car(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름이 null이 될 수 없습니다!");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이상이 될 수 없습니다!");
        }
        this.name = name;
    }
}
