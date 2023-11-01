package racingcar.model;

public final class Car {
    private final String name;
    private int position;

    public Car (String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void movePosition(){
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }



}
