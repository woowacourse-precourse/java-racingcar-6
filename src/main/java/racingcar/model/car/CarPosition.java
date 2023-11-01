package racingcar.model.car;

import racingcar.config.AppConfig;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(int distance) {
        checkOverFlow(distance);
        position += distance;
    }

    private void checkOverFlow(int distance) {
        if (distance > 0 && distance + position < 0) {
            throw new IllegalArgumentException("자동차 이동거리는 " + AppConfig.POSITION_MAX + "를 넘을 수 없습니다.");
        }
    }
}
