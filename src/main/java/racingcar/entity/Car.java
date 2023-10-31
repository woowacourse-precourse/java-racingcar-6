package racingcar.entity;

public class Car {

    private String name;
    private int distance;

    private Car(String name) {

    }

    public static Car createCar(String name){
        return new Car(name);
    }

}
