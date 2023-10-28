package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RacingCarResultTranslator {
    private Map<String, List<String>> translatedPositionMap = new HashMap<>();
    private Map<String, List<Integer>> carPositionMap;
    private Integer tryNumber;

    public RacingCarResultTranslator(Map<String, List<Integer>> carPositionMap, Integer tryNumber) {
        this.carPositionMap = carPositionMap;
        this.tryNumber = tryNumber;
        initializeTranslatedPositionMap();
    }

    private void initializeTranslatedPositionMap() {
        Set<String> carNameSet = carPositionMap.keySet();
        for (String carName : carNameSet) {
            translatedPositionMap.putIfAbsent(carName, new ArrayList<>());
        }
    }

    public Map<String, List<String>> translatePositionMap() {
        for (int step = 1; step <= tryNumber; step++) {
            translateOneStep(step);
        }
        return translatedPositionMap;
    }

    private void translateOneStep(Integer step) {
        Set<String> carNameSet = carPositionMap.keySet();
        for (String carName : carNameSet) {
            List<Integer> oneCarPositionList = carPositionMap.get(carName);
            int oneCarPosition = oneCarPositionList.get(step);
            String translatedCarPosition = translateCarPosition(oneCarPosition);
            List<String> translatedPositionList = translatedPositionMap.get(carName);
            translatedPositionList.add(translatedCarPosition);
        }
    }

    private String translateCarPosition(Integer carPosition) {
        String translatedCarPosition = "-".repeat(carPosition);
        if (translatedCarPosition.isEmpty()) {
            return " ";
        }
        return translatedCarPosition;
    }
}
