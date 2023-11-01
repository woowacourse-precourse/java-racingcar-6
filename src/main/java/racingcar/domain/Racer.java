package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Racer{
    private String name;
    private int distance;

    public Racer(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Racer(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() { return name; }

    public int getDistance() {
        return distance;
    }

    public void moveForward(int RandomNumber) {

        if (Judgment.isOverFourDistance(RandomNumber))
            this.distance += 1;
    }

    public String printDistance() {
              return (this.name +
                " : " +
                "-".repeat(this.distance));
    }
}
