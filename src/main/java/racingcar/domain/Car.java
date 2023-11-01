package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.Distance;
import racingcar.common.type.Name;
import racingcar.common.type.Names;

/**
 * 자동차 게임에서 사용되는 Car 도메인 클래스
 */
public class Car {
    private final Name name;
    private final Distance distance;

    private Car(Name name) {
        this.name = Name.of(name.getName());
        this.distance = Distance.of(0);
    }

    //주어진 Names로 Car 리스트를 생성
    public static List<Car> createCarList(Names names) {
        return names.getNameList()
                .stream()
                .map(nameString -> new Car(Name.of(nameString)))
                .collect(Collectors.toList());
    }

    // 움직임 전략에 따라 자동차를 이동시킴
    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            distance.increase();
        }
    }

    // 주어진 거리와 자신의 거리를 비교하여 승자인지 판별
    public boolean isWinner(int winnerDistance) {
        return distance.isEqual(winnerDistance);
    }

    // 자동차의 이름을 반환
    public String getName() {
        return name.getName();
    }

    // 자동차의 거리를 반환
    public int getDistance() {
        return distance.getDistance();
    }
}
