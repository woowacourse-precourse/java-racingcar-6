package view;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {
    public static void startPlayDisplay(){
        System.out.println("\n실행 결과");
    }
    public static void displayRaceResult(LinkedHashMap<String, Integer> raceResult){
        for (String carName : raceResult.keySet()) {
            System.out.println(carName + " : " + "-".repeat(raceResult.get(carName)));
        }
        System.out.println();
    }

    public static void displayWinners(List<String> winners){
        System.out.print("최종 우승자 : ");
        if (!winners.isEmpty()) {
            System.out.print(String.join(", ", winners));
        }
    }

}
