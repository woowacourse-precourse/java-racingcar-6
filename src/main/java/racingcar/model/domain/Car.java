package racingcar.model.domain;

public class Car {

    private final String name;//자동차의 이름을 나타내는 멤버변수 ->상수로 고정(바꿀수 없음)
    private int position = 0;//자동차의 현재 위치를 나타내는 멤버 변수, 0으로 초기 위치 고정
    public Car(String name) {//생성자 Car클래스 객체 생성
       this.name = name;    //생성자는 자동차의 이름을 매개변수로 받아 name에 설정
    }

    public void moveForward(int distance){//moveForward메서드 distance를 가져와 position에 누적
        position += distance;
    }

    public String getName(){//자동차 이름 반환
        return name;
    }
    public int getPosition(){//자동차 위치 반환
        return position;
    }
}
