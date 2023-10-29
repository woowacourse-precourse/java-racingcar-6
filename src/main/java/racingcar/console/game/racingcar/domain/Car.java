package racingcar.console.game.racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;

    public String getName() {
        return name;
    }

    private int location;

    public Car(String name) {
        this.name = name;
        this.location = location;
    }

    public void moveLocation() {
        if (Randoms.pickNumberInRange(0,9) > 3) {
            location += 1;
        }
    }

    public void indicateLocation() {
        System.out.print(name + " : ");
        System.out.println("-".repeat(location));
    }

    public int getLocation() {
        return location;
    }
}