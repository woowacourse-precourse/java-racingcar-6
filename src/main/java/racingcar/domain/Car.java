package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;
    //선언
    public Car(String name) {
        this.name = name;
    }
    //현재 위치
    public void moveForward(int distance) {
        position += distance;
    }
    //자동차 이름 호출
    public String getName() {
        return name;
    }
    //자동차 위치 호출
    public int getPosition() {
        return position;
    }
}