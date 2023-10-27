package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

    private String name;
    private int forwardCount;

    public Car(String name) {

        this.name = name;
        this.forwardCount = 0;
    }

    public int generateRandomNumber(){

        return Randoms.pickNumberInRange(0,9);
    }

    public void forward(){

        forwardCount++;
    }

    public String getName() {

        return name;
    }

    @Override
    public int compareTo(Car o) {

        return this.forwardCount - o.forwardCount;
    }
}
