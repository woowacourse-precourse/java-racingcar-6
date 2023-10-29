package racingcar;

public class Car {
    private String name;
    private int pos = 0;

    public Car(String name) {
        this.name = name;
    }
    public Car(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public void move(){
        pos++;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }
}
