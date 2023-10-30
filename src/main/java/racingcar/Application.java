package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Preference preference = new Preference();

        System.out.println(Printer.PRINT_PROGRESS);
        List<Integer> progress = new ArrayList<>(Collections.nCopies(preference.getSize(), 0));
        for (int i = 0; i < preference.getRound(); i++) {
            playEachRound(progress);
            Printer.printResultOfEachRound(preference.getCars(), progress);
        }

        Printer.printWinner(progress, preference.getCars());
        Console.close();
    }


    private static void playEachRound(List<Integer> progress) {
        for (int i = 0; i < progress.size(); i++) {
            rollTheDice(progress, i);
        }
    }

    private static void rollTheDice(List<Integer> progress, int index) {
        int dice = Randoms.pickNumberInRange(0, 9);
        if (dice >= 4) {
            int lastProgress = progress.get(index);
            progress.set(index, lastProgress + 1);
        }
    }
}
