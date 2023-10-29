package racingcar.domain.broadcast;

import java.util.HashMap;
import java.util.Map;

public class Broadcast {
    public static final StringBuilder stringBuilder = new StringBuilder();

    public static void broadcasting(HashMap<String, Integer> lineUp) {

        for (Map.Entry<String, Integer> carRecord : lineUp.entrySet()) {
            for (int i = 0; i < carRecord.getValue(); i++) {
                stringBuilder.append("-");
            }
            System.out.println(carRecord.getKey() + " : " + stringBuilder);
            stringBuilder.setLength(0);
        }
    }

    public static void prizeCeremony(HashMap<String, Integer> lineUp) {

    }
}
