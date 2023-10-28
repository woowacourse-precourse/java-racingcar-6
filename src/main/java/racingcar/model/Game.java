package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private int tryCount;
    private List<Car> carList;

    public Game(List<String> carNameList, int tryCount) {
        this.tryCount = tryCount;
        carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public String getRaceInfo() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public void step() {}
}
