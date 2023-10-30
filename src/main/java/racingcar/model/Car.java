package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        this.position += 1;
    }

    public int getPosition(){
        return position;
    }
    public String getName() {
        return name;
    }

}
