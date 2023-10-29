package racingcar.domain;

public class CarPosition implements Comparable<CarPosition> {

    private int position = 0;

    public void move(int value) {
        position = position + value;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(CarPosition carPosition) {
        return position - carPosition.position;
    }

}
