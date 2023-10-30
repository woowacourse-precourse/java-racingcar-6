package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if(randomNumber >= 4) {
            position += 1;
        }
    }

    public String status() {
        String statusString = name + " : ";
        for(int i = 0; i <  position; i++) {
            statusString += "-";
        }
        return statusString;
    }

    public int getPostion() {
        return position;
    }

    public String getName() {
        return name;
    }
}
