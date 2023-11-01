package racingcar.view;

import java.util.ArrayList;
import java.util.HashMap;

public final class Output {

    public static void outputGameProgress(HashMap<String,String> hashMap, String[] carNamesArray) {
        for (String car : carNamesArray) {
            System.out.println(car + " : " + hashMap.get(car));
        }
        System.out.println();
    }

    public static void outputFinalSoloWinner(ArrayList<String> soloWinner) {
        OutputMessage.outputFinalWinner();
        System.out.println(soloWinner.get(0));
    }

    public static void outputFinalJointWinners(ArrayList<String> jointWinners) {
        OutputMessage.outputFinalWinner();
        System.out.println(String.join(", ", jointWinners));
    }
}
