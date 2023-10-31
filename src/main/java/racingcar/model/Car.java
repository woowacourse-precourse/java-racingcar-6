package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public static Car of(String name){
        return new Car(name);
    }

    public void drive() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(this.name).append(" : ");
        IntStream.range(0,this.distance).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
