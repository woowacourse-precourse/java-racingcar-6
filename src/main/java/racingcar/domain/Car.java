package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private int position;
    private String name;

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Car(String name) {
        //생성시 이름 철자 개수 제한
        if (name.length() > 5) {
            throw new IllegalArgumentException();   //종료 되로록 try/catch 사용 X
        }
        this.name = name;
    }

    public void move() {
        int randnum = Randoms.pickNumberInRange(0, 9);
        if (randnum >= 4) {
            position++;
        }
    }
}
