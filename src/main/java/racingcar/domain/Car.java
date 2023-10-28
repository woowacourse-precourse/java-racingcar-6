package racingcar.domain;

import java.util.List;
import racingcar.dto.output.CarInfo;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    // 거리 증가
    public void increaseDistance() {
        distance++;
    }

    // CarInfo로 변환
    public CarInfo toCarInfo() {
        return new CarInfo(name, distance);
    }

    // 승자면 이름을 리스트에 추가
    public void addWinnerIfEqual(int maxDistance, List<String> winnerNames) {
        if (isWinner(maxDistance)) {
            winnerNames.add(this.name);
        }
    }

    // 승자인지 판별
    public boolean isWinner(int maxDistance) {
        return this.distance == maxDistance;
    }

    // 최대 이동 거리 계산
    public int calculateMaxDistance(int currentMaxDistance) {
        return Math.max(this.distance, currentMaxDistance);
    }
}
