package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int rand = Randoms.pickNumberInRange(0, 9);

        if (rand >= 4) {
            this.position++;
        } else {

        }
        System.out.println(name + " : " + "-".repeat(position));
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.getPosition(), this.position);
    }
}
