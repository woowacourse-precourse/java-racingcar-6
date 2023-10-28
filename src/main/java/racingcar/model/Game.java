package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
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


    public List<String> judgeWinner(List<String> carNameList, LinkedHashMap<String, Integer> locations) {

        List<String> winners = new ArrayList<>();
        int maxValue = Collections.max(locations.values());

        for (int i = 0; i < carNameList.size(); i++) {
            int value = locations.get(carNameList.get(i));
            if (value == maxValue) {
                winners.add(carNameList.get(i));
            }
        }
        return winners;
    }
}
