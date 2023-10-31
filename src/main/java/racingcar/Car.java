package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    String name;
    String distance;

    public Car(String name, String distance) {
        this.name = name;
        this.distance = distance;
    }

    public int move() {

        int num = Randoms.pickNumberInRange(0,9);

        if ( num >= 4 ) {
            this.distance += "-";
        }

        return num;
    }

    public void printInfo() {

        System.out.println(this.name + " : " + this.distance);
    }
}