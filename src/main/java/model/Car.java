package model;

import utils.Utils;

public class Car {
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

    public void move_forward(String onePlace) {
        this.nowPlace = this.nowPlace + onePlace;
    }

    public String getNowPlace() {
        return nowPlace;
    }

}
