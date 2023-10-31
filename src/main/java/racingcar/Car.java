package racingcar;

class Car {
    private String name;
    private int pos;

    public Car(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}