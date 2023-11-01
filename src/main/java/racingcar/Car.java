package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void proceed() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            distance++;
        }
    }

    @Override
    public int compareTo(Car o) {
        return o.getDistance() - distance;
    }

}
