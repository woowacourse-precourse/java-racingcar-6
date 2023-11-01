package Car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }

    private int currentLocation;

    Car(String name) {
        this.name = name;
        this.currentLocation = 0;
    }

    public void moveForwardOrStay() {
        int randomNumber = Randoms.pickNumberInRange(0, 10);

        if (randomNumber >= 4) {
            currentLocation++;
        }
    }

    public void printCurrentLocation() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.currentLocation; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
