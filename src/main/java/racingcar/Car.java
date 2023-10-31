package racingcar;

public class Car {

    private String name = null;
    private int pos = 0;

    public Car(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
