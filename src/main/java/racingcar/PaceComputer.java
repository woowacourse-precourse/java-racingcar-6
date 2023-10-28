package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PaceComputer {
    private static final int INITIAL_RANDOM_NUMBER = 0;
    private static final int LAST_RANDOM_NUMBER = 9;
    private static final int HURDLE_NUMBER_TO_DRIVE = 4;
    private final List<Integer> randomNumberList = new ArrayList<>();

    public LinkedHashMap<String, Integer> createDefaultPaceMap(Machines machines) {
        List<String> machineNameList = Arrays.asList(machines.getMachineNames().split(","));

        return machineNameList.stream()
                .collect(Collectors.toMap(
                        machineName -> machineName,
                        driveSuccessNumber -> 0,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new
                ));
    }

    private int generateRandomNumber(int initialNumber, int lastNumber){
        return pickNumberInRange(initialNumber, lastNumber);
    }

    public List<Integer> getRandomNumberList() {
        return randomNumberList;
    }

    public void updatePaceMap(Machines machines, LinkedHashMap<String, Integer> paceMap) {
        paceMap.forEach((machineName, driveSuccessNumber) -> {
            int randomNumber = generateRandomNumber(INITIAL_RANDOM_NUMBER, LAST_RANDOM_NUMBER);

            if (randomNumber >= HURDLE_NUMBER_TO_DRIVE) {
                paceMap.put(machineName, driveSuccessNumber + 1);
            }
            randomNumberList.add(paceMap.get(machineName));
        });
    }
}