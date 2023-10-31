package racingcar.service.domain;

import java.util.Objects;

// TODO: Car가 검증해야할 부분 방어 코드 작성
// TODO: public 메서드 단위 테스트
// TODO: getter 없애도록 고민해볼 것
public class Car {
    public final CarName name;
    private final Engine engine;
    private int totalMoveCount;

    public Car(String name, Engine engine) {
        this.name = new CarName(name);
        this.engine = engine;
    }

    public void moveCar() {
        int power = startEngine();
        if (canMove(power)) {
            this.totalMoveCount++;
        }
    }

    private int startEngine() {
        return engine.generateNumber();
    }

    private boolean canMove(int power) {
        return power >= 4;
    }

    public int getTotalMoveCount() {
        return totalMoveCount;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", totalMoveCount=" + totalMoveCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
