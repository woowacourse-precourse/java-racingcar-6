package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Preference preference = makePreference();

        System.out.println(Printer.PRINT_PROGRESS);
        List<Integer> progress = new ArrayList<>(Collections.nCopies(preference.cars().size(), 0));
        for (int i = 0; i < preference.round(); i++) {
            playEachRound(progress);
            Printer.printResultOfEachRound(preference.cars(), progress);
        }

        Printer.printWinner(progress, preference.cars());
        Console.close();
    }

    private static Preference makePreference() {
        return new Preference(requestNames(), requestRound());
    }

    private static int requestRound() {
        System.out.println(Printer.REQUEST_ROUND);
        return Scanner.extractRound(Console.readLine());
    }

    private static List<String> requestNames() {
        System.out.println(Printer.REQUEST_NAME);
        return Scanner.extractNames(Console.readLine());
    }

    private record Preference(List<String> cars, int round) {
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
