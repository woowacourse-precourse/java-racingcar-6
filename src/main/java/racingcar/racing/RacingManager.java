package racingcar.racing;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.playrule.RacingRule;
import racingcar.racingcar.Car;
import racingcar.racingcar.RacingParticipants;

/**
 * @author 민경수
 * @description racing manager
 * @since 2023.10.27
 **********************************************************************************************************************/
public class RacingManager {

    private final List<Car> cars;
    private int count;

    public RacingManager(RacingParticipants racingParticipants, int count, RacingRule racingRule) {
        this.cars = racingParticipants.getParticipantNames()
                .stream()
                .map(e -> new Car(racingRule, e, 0))
                .collect(Collectors.toList());

        this.count = count;
    }

    public boolean isEnd() {
        return this.count == 0;
    }

    public void processRacing() {
        cars.forEach(Car::move);
        count--;
    }

    public List<Car> currentCarPositions() {
        return cars;
    }

    public List<String> getWinnerName() {
        int maxPosition = this.cars.stream()
                .map(Car::position)
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("자동차 리스트가 비어 있습니다."));

        return this.cars.stream()
                .filter(car -> car.position() == maxPosition)
                .map(Car::name)
                .collect(Collectors.toList());
    }
}