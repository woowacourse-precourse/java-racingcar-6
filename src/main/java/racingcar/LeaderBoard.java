package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeaderBoard {
    private final List<Integer> paceMapValueList = new ArrayList<>();

    public void showRace(Machines machines, Lap lap, PaceComputer paceComputer) {

        System.out.println();
        System.out.println("실행 결과");

        LinkedHashMap<String, Integer> currentPaceMap = paceComputer.createDefaultPaceMap(machines);

        for (int i = 0; i < Integer.parseInt(lap.getLap()); i++) {
            paceComputer.updatePaceMap(currentPaceMap);
            paceMapValueList.addAll(currentPaceMap.values());

            currentPaceMap.forEach((machineName, driveSuccessNumber) ->
                    System.out.println(machineName + " : " + convertPaceToGraphic(driveSuccessNumber)));

            System.out.println();
        }

        showResult(currentPaceMap);
    }

    private void showResult(LinkedHashMap<String, Integer> paceMap) {
        int largestDriveNumber = paceMap.values().stream().max(Integer::compareTo).orElse(0);

        String winners = paceMap
                .entrySet()
                .stream()
                .filter(driveSuccessNumber -> driveSuccessNumber.getValue().equals(largestDriveNumber))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(","));

        System.out.print("최종 우승자 : " + winners);
    }

    private String convertPaceToGraphic(int driveSuccessNumber) {
        return "-".repeat(driveSuccessNumber);
    }

    public List<Integer> getPaceMapValueList() {
        return paceMapValueList;
    }
}