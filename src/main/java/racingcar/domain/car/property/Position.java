package racingcar.domain.car.property;

public class Position {

    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 위치는 음수일 수 없습니다.");
        }
    }

    public void increment() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
