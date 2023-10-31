package racingcar;

import java.util.Comparator;

class CarMovingDistanceComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getMovingDistance() > car2.getMovingDistance()) {
            return -1;
        } else if (car1.getMovingDistance() < car2.getMovingDistance()) {
            return 1;
        }
        return 0;
    }
}

public class Car {
    private String name;
    private int movingDistance;

    public Car(String name, int movingDistance) {
        this.name = name;
        this.movingDistance = movingDistance;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getMovingDistance() {
        return movingDistance;
    }

    public void setMovingDistance(int movingDistance) {
        this.movingDistance = movingDistance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(movingDistance);
    }
}
