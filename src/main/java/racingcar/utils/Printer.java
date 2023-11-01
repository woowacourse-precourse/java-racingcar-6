package racingcar.utils;

import racingcar.configs.Config;
import racingcar.racer.Racer;

import java.util.List;

public class Printer {
    public static void printCurrentRaceResult(List<Racer>racerList){
        for (Racer racer : racerList){
            String name = racer.getName();
            Integer racerPos = racer.getCurrentPos();

            StringBuilder sb = new StringBuilder();
            sb.append(name).append(" : ").append(Config.POS_INDICATOR.repeat(racerPos));
            System.out.println(sb.toString());
        }
        System.out.println();
    }
    public static void printFinalResult(List<String>winnerList){
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        sb.append(String.join(", ", winnerList));
        System.out.println(sb.toString());
    }

}