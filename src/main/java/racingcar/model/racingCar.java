package racingcar.model;

public class racingCar implements Car {
    private int position = 0;
    private String name;
    public racingCar(String name) {
        this.name = name;
    }
    @Override
    public int getPosition() {
        return position;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void move() {
        position++;
    }
}
