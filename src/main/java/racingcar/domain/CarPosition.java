package racingcar.domain;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition from(int position) {
//        validate();
        return new CarPosition(position);
    }

    public int getPosition() {
        return position;
    }

    public CarPosition next() {
        return new CarPosition(this.position + 1);
    }
}
