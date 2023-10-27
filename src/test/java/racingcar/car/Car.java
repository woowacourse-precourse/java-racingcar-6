package racingcar.car;

public class Car {
    private String name;
    public Car(String name) {
        if (name == null) throw new IllegalArgumentException("이름이 null이 될 수 없습니다!");
        this.name = name;
    }
}
