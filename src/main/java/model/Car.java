package model;

import utils.Utils;

public class Car {
    final static int FORWARDING_THRESHOLD = 4;
    final static String ONE_PLACE = "-";
    String name;
    String nowPlace = "";
    Utils utils = new Utils();

    public Car(String name) {
        utils.isOverLength(name);
        utils.isEmpty(name);
        utils.hasSpace(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        this.nowPlace = this.nowPlace + ONE_PLACE;
    }

    public String getNowPlace() {
        return nowPlace;
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= FORWARDING_THRESHOLD) {
            moveForward();
        }
    }

}
