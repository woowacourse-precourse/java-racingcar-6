package racingcar.driver;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public Map<String, String> makeDriverRoster(String drivers) {
        Map<String, String> driverMap = new HashMap<>();
        String[] driverNames = drivers.split(",");
        for (String driverName : driverNames) {
            driverMap.put(driverName, "");
        }
        return driverMap;
    }

    public void validateDriverRoster(Map<String, String> driverMap) {
        for (String driverName : driverMap.keySet()) {
            if (driverName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
            }
        }
    }
}

