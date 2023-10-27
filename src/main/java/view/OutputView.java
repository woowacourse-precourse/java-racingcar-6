package view;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputView {
    public static void displayRaceResult(HashMap<String, Integer> raceResult){
        System.out.println("실행 결과");
        for (String carName : raceResult.keySet()) {
            System.out.println(carName + " : " + "-".repeat(raceResult.get(carName)));
        }
    }

    public static void displayWinners(ArrayList<String> winners){
        System.out.print("최종 우승자: ");
        if(winners.size() > 1){
            for(String winner : winners){
                System.out.print(winner + ", ");
            }
        } else if (winners.size() == 1) {
            System.out.print(winners.get(0));
        }
    }

}
