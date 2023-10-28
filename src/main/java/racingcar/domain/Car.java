package racingcar.domain;

public class Car implements Comparable<Car>{
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(){
        distance += 1;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car car) {
        if(car.distance < distance){
            return 1;
        } else if (car.distance > distance) {
            return -1;
        }
        return 0;
    }
}
