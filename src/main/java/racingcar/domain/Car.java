package racingcar.domain;

public class Car {

    String name;
    int location = 0;

    public Car(String name){
        this.name = name;
    }

    public void randomMove() {
        //TODO 직진 여부 판단
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
