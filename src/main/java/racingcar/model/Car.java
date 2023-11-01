package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ConstantNumber;

public class Car implements Comparable<Car> {
    private String name;
    private int distance;

    Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder distanceStr = new StringBuilder();
        distanceStr.append(name + " : ");
        for (int i = 0; i < distance; i++) {
            distanceStr.append("-");
        }
        return distanceStr.toString();
    }

    void moveRandom() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= ConstantNumber.STEP_PERCENTAGE) {
            distance = distance + 1;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.distance - o.distance;
    }
}
