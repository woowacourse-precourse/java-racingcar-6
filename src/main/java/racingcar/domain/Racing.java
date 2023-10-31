package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Racing {
    public Racing(List<Car> cars) {
        this.participant = cars;
    }

    List<Car> participant = new ArrayList<>();

    public void drive(Car car) {
        car.go(createMovePoint());
    }

    private int createMovePoint() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String play(int turnLeft) {
        if(turnLeft == 0) return "ANS";
        for(Car car : participant) {
            this.drive(car);
        }
        return play(turnLeft - 1);
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
}
