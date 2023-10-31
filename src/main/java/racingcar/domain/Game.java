package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private Cars cars;
    private TryCount tryCount;

    public void play() {
        for (int i = 0; i < tryCount.getTryCount(); ++i) {
            List<Integer> randomNumbers = IntStream.range(0, cars.getSize())
                .mapToObj(idx -> Randoms.pickNumberInRange(0, 9))
                .collect(Collectors.toList());
            cars.moveAllCars(randomNumbers);
            cars.printCarNamesAndPositions();
        }
    }
}
