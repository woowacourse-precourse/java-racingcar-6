package view;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputView {
    public static void displayPlayResult(){
        System.out.println("\n실행 결과");
    }
    public static void displayRaceResult(HashMap<String, Integer> raceResult){
        for (String carName : raceResult.keySet()) {
            System.out.println(carName + " : " + "-".repeat(raceResult.get(carName)));
        }
        System.out.println();
    }

    public static void displayWinners(ArrayList<String> winners){
        System.out.print("최종 우승자 : ");
        if (!winners.isEmpty()) {
            System.out.print(String.join(", ", winners));
        }
    }

}
