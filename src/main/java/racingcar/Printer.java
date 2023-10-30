package racingcar;

import java.util.List;

public class Printer {
    public static void printRaceResultInProgressWithRacerList(List<Racer>racerList){
        for (Racer racer : racerList){
            String name = racer.getName();
            Integer racerPos = racer.getCurrentPos();

            StringBuilder sb = new StringBuilder();
            sb.append(name).append(" : ").append("-".repeat(racerPos));
            System.out.println(sb.toString());
        }
    }
}