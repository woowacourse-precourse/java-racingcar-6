package racingcar.game;

import racingcar.domain.Create;

public class Car {

    private String name;
    private int distance;

    private String distanceString;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        this.distanceString = "";
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getDistanceString() {
        return distanceString;
    }

    public void move() {
        Create create = new Create();
        int randomNumber = create.generateRandomNumbers();
        if (randomNumber >= 4) {
            this.distance += 1;
            this.distanceString = distanceString + "-";
        }
    }


}
