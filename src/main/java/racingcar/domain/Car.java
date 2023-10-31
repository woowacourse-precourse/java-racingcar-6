package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.Distance;
import racingcar.common.type.Name;
import racingcar.common.type.Names;

public class Car {
    private final Name name;
    private final Distance distance;

    private Car(Name name) {
        this.name = Name.of(name.getName());
        this.distance = Distance.of(0);
    }

    public static List<Car> createCarList(Names names) {
        return names.getNameList()
                .stream()
                .map(nameString -> new Car(Name.of(nameString)))
                .collect(Collectors.toList());
    }

    // 이동
    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            distance.increase();
        }
    }

    // 승자인지 판별
    public boolean isWinner(int winnerDistance) {
        return distance.isEqual(winnerDistance);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
