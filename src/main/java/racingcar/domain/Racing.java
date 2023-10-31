package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import racingcar.Dto.CurrentRacingStatusDto;

public class Racing {
    public Racing(String[] userName) {
        this.participant = Arrays.stream(userName)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public Racing(List<Car> cars) {
        this.participant = cars;
    }

    private final List<Car> participant;

    public void drive(Car car) {
        car.go(createMovePoint());
    }

    private int createMovePoint() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public CurrentRacingStatusDto play() {
        for(Car car : participant) {
            this.drive(car);
        }
        return new CurrentRacingStatusDto(this);
    }

    public List<String> computeResult() {
        return participant.stream()
                .collect(Collectors.groupingBy(Car::getDistance, TreeMap::new, Collectors.toList()))
                .lastEntry()
                .getValue()
                .stream()
                .map(Car::getName)
                .toList();
    }

    public List<Car> getParticipant() {
        return participant;
    }
}
