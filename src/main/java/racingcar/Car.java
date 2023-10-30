package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    String name;
    int distance;

    Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String toString() {
        StringBuilder distanceStr = new StringBuilder();
        distanceStr.append(name + " : ");
        for(int i = 0; i < distance; i++) {
            distanceStr.append("-");
        }
        return distanceStr.toString();
    }

    void moveRandom() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >= ConstantNumber.STEP_PERCENTAGE) {
            distance = distance + 1;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.distance - o.distance;
    }
}
