package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Car {

    private Map<String, Integer> carInfo = new LinkedHashMap<String, Integer>();

    public Map<String, Integer> getCarInfo() {
        return carInfo;
    }

    public void setCarName() {
        String str = Console.readLine();
        String[] names = str.split(",");

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("Invalid argument: " + name);
            }
            carInfo.put(name,0);
        }
    }
}
