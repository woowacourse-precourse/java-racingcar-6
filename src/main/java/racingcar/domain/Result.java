package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    List<Integer> winNumber = new ArrayList<>();
    List<String> winner = new ArrayList<>();

    public void racePrint(List<String> raceCars, List<Integer> raceMove) {
        for (int i = 0; i < raceCars.size(); i++) {
            System.out.print(raceCars.get(i) + " : ");
            //System.out.println(raceMove.get(i));
            for (int j = 0; j < raceMove.get(i); j++) {
                System.out.print("-");
            }
            System.out.println(" ");
        }
    }

    public void resultPrint(List<String> raceCars, List<Integer> raceMove) {
        /*int max = Collections.max(raceMove);*/
        int max = 0;
        for (int i = 0; i < raceMove.size(); i++) {
            if (max < raceMove.get(i)) {
                max = raceMove.get(i);
            }
        }
        for (int i = 0; i < raceMove.size(); i++) {
            if ((raceMove.get(i)).equals(max)) {
                winNumber.add(i);
            }
        }
        for (int i = 0; i < winNumber.size(); i++) {
            winner.add(raceCars.get(winNumber.get(i)));
        }
        System.out.print("최종 우승자 : ");
        String win = String.join(", ", winner);
        System.out.println(win);
    }
}
