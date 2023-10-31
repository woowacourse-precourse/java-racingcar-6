package Model;

import camp.nextstep.edu.missionutils.Randoms;


public class Car {

    private int randomNum;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void calRandomNum() {
        randomNum = Randoms.pickNumberInRange(0, 9);
    }

    public void forward() { // 자동차마다 어떻게 나누지? -> list안에 클래스를 넣자!
        calRandomNum();
        if (randomNum > 3) {
            position += 1;
        }
    }

}
