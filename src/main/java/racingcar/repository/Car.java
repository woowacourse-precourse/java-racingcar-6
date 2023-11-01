package racingcar.repository;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
    //  유효값 검증은 도메인 & view에서 모두 검증한다
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int moves) {
        position += moves;
    }
}