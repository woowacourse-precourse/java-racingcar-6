package racingcar.view;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringJoiner;

public class OutputView {
    public static void showEachRoundResultOf(HashMap<String, String> participants) {
        for (String car : participants.keySet()) {
            String recordOfCar = participants.get(car);

            StringBuilder sb = new StringBuilder();
            sb.append(car).append(" : ").append(recordOfCar);

            String eachResultOfCar = sb.toString();
            System.out.println(eachResultOfCar);
        }
        System.out.println();
    }

    public static void showFinalResultOf(HashMap<String, String> participants) {
        Collection<String> values = participants.values();
        Integer max = Collections.max(values.stream().map(h -> h.length()).toList());

        String finalWinner = getFinalWinner(participants, max);
        System.out.println("최종 우승자 : " + finalWinner);
    }

    public static String getFinalWinner(HashMap<String, String> participants, Integer max) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String car : participants.keySet())
            if (participants.get(car).length() == max) stringJoiner.add(car);

        return stringJoiner.toString();
    }
}
