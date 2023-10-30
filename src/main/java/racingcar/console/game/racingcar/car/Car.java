package racingcar.console.game.racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void operate() {
        if (Randoms.pickNumberInRange(0,9) > 3) {
            location += 1;
        }
    }

    public void indicateLocation() {
        System.out.print(name + " : ");
        System.out.println("-".repeat(location));
    }

    public String getName() {
        return name;
    }
    public int getLocation() {
        return location;
    }
}
