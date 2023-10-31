package racingcar.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Output {

    public static void outputGameProgress(HashMap<String,String> hashMap) {
        for (Map.Entry<String,String> m : hashMap.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
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
