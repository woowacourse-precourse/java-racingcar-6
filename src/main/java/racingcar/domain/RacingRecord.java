package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingRecord {

    public Map<String, Integer> initRecord(List<String> cars) {
        Map<String, Integer> records = new HashMap<>();

        for(String car : cars) {
            records.put(car, 0);
        }

        return records;
    }

    public Map<String, Integer> record(List<String> cars, Map<String, Integer> records) {
        for(String car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            records = forwardMovement(car, records, randomValue);
        }
        return records;
    }

    public Map<String, Integer> forwardMovement(String car, Map<String, Integer> records, int randomValue) {
        boolean isForwardMovement = checkForwardMovement(randomValue);

        if(isForwardMovement) {
            records.put(car, records.get(car) + 1);
        }

        return records;
    }

    private boolean checkForwardMovement(int randomValue) {
        if(randomValue >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public String printRacingRecord(List<String> cars, Map<String, Integer> records) {
        String print = "";
        for(String car : cars) {
            String carForwardLine = createForwardLine(records.get(car));
            print += car + " : " + carForwardLine + "\n";
        }

        return print;
    }

    private String createForwardLine(int count) {
        String carForwardLine = "";

        for(int i = 0; i < count; i++) {
            carForwardLine += "-";
        }

        return carForwardLine;
    }

}
