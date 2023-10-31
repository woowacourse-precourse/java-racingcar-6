package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int num;
    public Car(String car_name) {
        name = car_name;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public void rolling() {
        int value = Randoms.pickNumberInRange(0, 9);
        if(value >= 4) {
            num++;
        }
    }
    public void forward() {
        for(int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }


}
