package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String name,int position) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
