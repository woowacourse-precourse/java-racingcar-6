package racingcar.domain;

public class Car {
    String name;
    int distance;

    Car(String name){
        this.name = name;
        // this.distance = 0; -> 초기화가 0으로 됨
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
