package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    List<Car> carList;
    RacingSetting racingSetting;

    void printMovingResult() {
        for (Car currentCar: carList) {
            currentCar.printInformation();
        }
    }

    void printWinner() {
        Map<Integer, List<String>> destinationToNamesMap = new HashMap<>();
        for (Car currentCar: carList) {
            addDestinationName(destinationToNamesMap, currentCar.getDestination(), currentCar.getName());
        }
        int maxDestination = Collections.max(destinationToNamesMap.keySet());
        if (destinationToNamesMap.containsKey(maxDestination)) {
            List<String> names = destinationToNamesMap.get(maxDestination);
            System.out.print("최종 우승자 : ");
            for (String currnetName: names) {
                System.out.print(currnetName);
                if (!currnetName.equals(names.get(names.size() - 1))) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private static void addDestinationName(Map<Integer, List<String>> map, int key, String value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
}
