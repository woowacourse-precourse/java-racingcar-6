package racingcar.domain;

import java.util.List;

public abstract class Vehicle implements Comparable<Vehicle> {

    private static final int SAME_DISTANCE = 0;
    private static final String COLUMN = " : ";

    protected String name;
    protected Distance distance;

    public void printName() {
        String nameString = this.name + COLUMN;
        System.out.print(nameString);
    }

    public void printDistance() {
        this.distance.printDistance();
    }

    public boolean isSameDistance(Vehicle otherVehicle) {
        if (this.distance.compareTo(otherVehicle.distance) == SAME_DISTANCE) {
            return true;
        }
        return false;
    }

    public void addCarName(List<String> winnerList) {
        winnerList.add(this.name);
    }

    public abstract void advance();

    @Override
    public int compareTo(Vehicle otherVehicle) {
        return this.distance.compareTo(otherVehicle.distance);
    }
}
