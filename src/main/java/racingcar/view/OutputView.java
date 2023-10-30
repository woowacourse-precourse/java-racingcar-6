package racingcar.view;

import racingcar.property.OutputProperty;

import static racingcar.property.OutputProperty.*;

public class OutputView {
    public static void outputForRaceStart(){
        System.out.println(RACE_START);
    }

    public static void outputForRaceCount(){
        System.out.println(RACE_COUNT);
    }

    public static void outputForRacingResult(String roundResults){
        System.out.println(RACING_RESULT);
        System.out.println(roundResults);
    }

    public static void outputForLineBreak(){
        System.out.println();
    }
}
