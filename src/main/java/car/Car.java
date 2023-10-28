package car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public int distance;
    public String name;

    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
