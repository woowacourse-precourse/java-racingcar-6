package racingcar;

public class Car {
    private final String name;

    //car 객체 생성시 position은 0으로 설정
    private int position = 0;

    //name을 받고 car 객체를 생성하는 생성자
    public Car(String name) {
        this.name = name;
    }
    // 자동차의 위치를 증가
    public void move(){
        position++;
    }
    // 자동차 이름을 반환
    public String getName() {
        return name;
    }
    // 자동차의 현재 위치를 반환
    public int getPosition() {
        return position;
    }
}
