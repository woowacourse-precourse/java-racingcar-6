package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LeaderBoard {

    public void showRace(Machines machines, Lap lap, PaceComputer paceComputer) {

        System.out.println();
        System.out.println("실행 결과");

        LinkedHashMap<String, Integer> paceMap = paceComputer.createDefaultPaceMap(machines);

        for (int i = 0; i < Integer.parseInt(lap.getLap()); i++) {
            paceComputer.updatePaceMap(paceMap);

            paceMap.forEach((machineName, driveSuccessNumber) ->
                    System.out.println(machineName + " : " + driveSuccessNumber));

            System.out.println();
        }
    }
}
