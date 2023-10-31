package racingcontroller;

import java.util.LinkedHashMap;

public class CarMapGenerator {
    public static String[] cutName(String userCarName) {
        return userCarName.split(",");
    }

    public static LinkedHashMap<String, StringBuilder> makeLinkedHashMap(String[] userCarName) {
        LinkedHashMap<String, StringBuilder> carName = new LinkedHashMap<>();
        for (String i : userCarName) {
            carName.put(i, new StringBuilder(""));
        }
        return carName;
    }
}
