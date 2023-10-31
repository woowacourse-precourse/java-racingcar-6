package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeaderBoard {
    private final List<LinkedHashMap<String, Integer>> paceMapList = new ArrayList<>();

    public void showRace(Cars cars, RaceLap raceLap, PaceComputer paceComputer) {

        System.out.println();
        System.out.println("실행 결과");

        LinkedHashMap<String, Integer> currentPaceMap = paceComputer.createDefaultPaceMap(cars);

        int raceLapNumber = Integer.parseInt(raceLap.getRaceLapNumber());

        for (int i = 0; i < raceLapNumber; i++) {
            paceComputer.updatePaceMap(currentPaceMap);

            currentPaceMap.forEach((carName, driveSuccessNumber) ->
                    System.out.println(carName + " : " + convertPaceToGraphic(driveSuccessNumber)));
            System.out.println();

            paceMapList.add(new LinkedHashMap<>(currentPaceMap));
        }

        showResult(currentPaceMap);
    }

    private void showResult(LinkedHashMap<String, Integer> paceMap) {
        String winners = pickWinners(paceMap);

        System.out.print("최종 우승자 : " + winners);
    }

    private String pickWinners(LinkedHashMap<String, Integer> paceMap) {
        int largestDriveNumber = paceMap.values().stream().max(Integer::compareTo).orElse(0);

        Stream<Entry<String, Integer>> winnersInPaceMapStream =
                paceMap.entrySet()
                        .stream()
                        .filter(paceMapInSet -> paceMapInSet.getValue().equals(largestDriveNumber));

        Stream<String> winnersInStream = winnersInPaceMapStream.map(Map.Entry::getKey);

        return winnersInStream.collect(Collectors.joining(", "));
    }

    private String convertPaceToGraphic(int driveSuccessNumber) {
        return "-".repeat(driveSuccessNumber);
    }

    public List<LinkedHashMap<String, Integer>> getPaceMapList() {
        return paceMapList;
    }
}