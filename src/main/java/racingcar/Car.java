package racingcar;

public class Car {

    private String name;
    private int moveCnt;


    // 이름을 설정합니다.
    public Car(String name) {
        this.name = name;
        this.moveCnt = 0;
    }

    // TODO : 전진합니다.
    public void move() {
        this.moveCnt++;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public String getName() {
        return name;
    }
}
