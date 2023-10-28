package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class Game {
    public List<String> splitCarName(String carName) {
        List<String> carNameList = new ArrayList<>();
        String[] carNames = carName.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNameList.add(carNames[i]);
        }
        return carNameList;
    }

    public List<String> judgeWinner(List<Car> cars) {

        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(Integer.MIN_VALUE);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName)
                .collect(Collectors.toList());
    }
}
