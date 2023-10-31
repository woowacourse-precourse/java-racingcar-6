package racingcar.util;

import java.util.HashMap;

public class Converter {
    public static HashMap<String, String> convertStringToHashMap(String[] carList) {
        HashMap<String, String> participants = new HashMap<>();
        for (String car : carList)
            participants.put(car, "");
        return participants;
    }
}
