package racingcar;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void go() {
        status++;
    }


    @Override
    public int compareTo(Car o) {
        return o.status - status;
    }
}
