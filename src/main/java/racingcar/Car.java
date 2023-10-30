package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

    public String name;
    public Integer distance;

    @Override
    public int compareTo(Car o) {
        return o.distance - distance;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void goOrStop() {
        int temp = Randoms.pickNumberInRange(0, 9);
        if (temp >= 4) {
            this.distance++;
        }
    }

    public void printState() {
        String bar = "-".repeat(this.distance);
        System.out.println(this.name + " : " + bar);
    }
}
