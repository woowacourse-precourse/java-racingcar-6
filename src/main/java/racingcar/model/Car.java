package racingcar.model;

public class Car {

    private Integer distance;
    private final String name;

    public Car(String name) {
        this.distance = 0;
        this.name = name;
    }

    public void forward(){
        this.distance++;
    }

    public Car maxDistanceCar(Car car) {
        if (this.distance >= car.distance) {
            return this;
        }else{
            return car;
        }
    }

    public boolean isSameDistance(Car car) {
        if (this.distance == car.distance) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
