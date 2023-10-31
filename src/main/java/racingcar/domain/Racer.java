package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Racer{
    private String name;
    private int distance;

    public Racer(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() { return name; }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        int random = Randoms.pickNumberInRange(0, 9);

        if (Judgment.isOverFourDistance(random))
            this.distance += distance;
    }

    public void printDistance() {
        System.out.println(this.name +
                " : " +
                "-".repeat(this.distance));
    }
}
