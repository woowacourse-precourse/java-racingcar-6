package racingcar;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PaceComputer {

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
}
