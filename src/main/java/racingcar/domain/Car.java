package racingcar.domain;

public class Car {

    private final String name;

    private final int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName(){
        return name;
    }

    public int getCarPosition(){
        return position;
    }

}
