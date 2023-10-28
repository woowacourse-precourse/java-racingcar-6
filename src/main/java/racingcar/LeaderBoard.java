package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
                    System.out.println(machineName + " : " + driveSuccessNumber));

            System.out.println();
        }
    }

    public List<Integer> getPaceMapValueList() {
        return paceMapValueList;
    }
}
