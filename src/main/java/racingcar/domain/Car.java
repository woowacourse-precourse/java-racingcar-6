package racingcar.domain;

public class Car {
    public String name;
    public String status = "";
    public int distance = 0;

    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("이름에 대한 예외처리");
        this.name = name;
    }

    public void move(int randomNumber, Car car) {
        if (randomNumber >= 4) {
            car.distance++;
            car.status += "-";
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
