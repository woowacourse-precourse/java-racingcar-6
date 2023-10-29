package racingcar.domain.broadcast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        int maxValue = 0;
        for (int value : lineUp.values()) {
            if (value > maxValue) maxValue = value;
        }

        List<String> winnerList = new ArrayList<>();
        for (Map.Entry<String, Integer> carRecord : lineUp.entrySet()) {
            if (carRecord.getValue() == maxValue) {
                winnerList.add(carRecord.getKey());
            }
        }

        System.out.println(winnerList.toString().replaceAll("[\\[\\]]",""));
    }
}
