package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    private final String name;
    private String location = "";


    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {

        int randomNumber = pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            changeLocation();
        }

    }

    public void printLocation() {
        System.out.println(this.name + " : " + this.location);
    }

    public int getMovedDistance() {
        return this.location.length();
    }

    @Override
    public String toString() {
        return this.name + " : " + this.location;
    }

    private void changeLocation() {
        this.location += "-";
    }
}
