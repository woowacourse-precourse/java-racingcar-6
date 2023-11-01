package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    List<Integer> winNumber = new ArrayList<>();
    List<String> winner = new ArrayList<>();
    public void racePrint(List<String> raceCars, List<Integer> raceMove) {
        for (int i = 0; i < raceCars.size(); i++) {
            System.out.print(raceCars.get(i) + " :");
            for (int j = 0; j < raceMove.get(i); j++) {
                System.out.print(" -");
            }
            System.out.println(" ");
        }
    }

    public void resultPrint(List<String> raceCars, List<Integer> raceMove) {
        int max = Collections.max(raceMove);
        for (int i = 0; i < raceMove.size(); i++) {
            winNumber.add(raceMove.indexOf(max));
        }
        for(int i=0; i < raceCars.size(); i++) {
            winner.add(raceCars.get(winNumber.get(i)));
        }
        String win = String.join(",", winner);
    }
}
