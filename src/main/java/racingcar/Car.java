package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void go() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            distance++;
        }
    }

    public void location() {
        System.out.println(this.name + " : " + "-".repeat(this.distance));
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.distance, this.distance);
    }

    public String getName() {
        return this.name;
    }
    public int getDistance() {
        return this.distance;
    }
}
