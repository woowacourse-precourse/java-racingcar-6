package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private String position = "";

    public Car(String name) {
        this.name = name;
    }

    private void move() {
        // 자동차를 전진시키는 메서드
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position += "-";
        }
    }

    private void printStatus() {
        System.out.println(this.name + " : " + this.position);
    }

    public void run() {
        // 자동차를 실행시키는 메서드
        this.move();
        this.printStatus();
    }

    public int getPositionLength() {
        return this.position.length();
    }

    public String getName() {
        return this.name;
    }
}
