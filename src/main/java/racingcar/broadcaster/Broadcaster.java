package racingcar.broadcaster;

import java.util.List;
import java.util.Map;

public class Broadcaster {
    public static void printWinner(List<String> carNames){
        String joinedNames = String.join(", ", carNames);
        System.out.println("최종 우승자 : " + joinedNames);
    }
    public static void printCurrentRace(Map<String, Integer> carLocations){
        for (Map.Entry<String, Integer> entry : carLocations.entrySet()) {
            printCarLocation(entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
    private static void printCarLocation(String name, Integer location){
        System.out.println(name + " : " + "-".repeat(Math.max(0, location)));
    }
}
