package racingcar.model;

public class racingCar implements car {
    private int position = 0;
    private String name;
    public racingCar(String name) {
        this.name = name;
    }
    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }
    @Override
    public void move() {
        position++;
    }
}
