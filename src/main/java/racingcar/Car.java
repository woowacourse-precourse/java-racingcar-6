package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    // 생성자: 클래스 생성시, 반드시 name을 초기화한 후 name을 변경할 수 없도록 보호합니다.
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    public void choosePosition() {
        int num = Randoms.pickNumberInRange(0,9);
        if (num >= 4) {
            position++;
        }
        System.out.print(this.name + " : ");
        for (int i=0; i<this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
