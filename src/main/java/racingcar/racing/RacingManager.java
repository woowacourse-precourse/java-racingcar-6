package racingcar.racing;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.properties.RacingProperty;
import racingcar.racingcar.Car;

/**
 * @author 민경수
 * @description racing manager
 * @since 2023.10.27
 **********************************************************************************************************************/
public class RacingManager {

    private final List<Car> cars;
    private int moveChanceCount;

    public RacingManager(RacingProperty racingProperty) {
        this.cars = racingProperty.racingParticipants()
                .participantNames()
                .stream()
                .map(e -> new Car(racingProperty.racingRule(), e, 0))
                .collect(Collectors.toList());

        this.moveChanceCount = racingProperty.moveChanceCount();
    }

    public boolean isEnd() {
        return this.moveChanceCount == 0;
    }

    public void processRacing() {
        cars.forEach(Car::move);

        reduceMoveChance();
    }

    public List<Car> cars() {
        return cars;
    }

    public List<String> getRacingWinners() {
        return this.cars.stream()
                .filter(car -> car.position() == getMaxPosition())
                .map(Car::name)
                .collect(Collectors.toList());
    }

    protected int moveChanceCount() {
        return moveChanceCount;
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .map(Car::position)
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("자동차 리스트가 비어 있습니다."));
    }

    private void reduceMoveChance() {
        moveChanceCount--;
    }

}