package racingcar.view;

public class OutputView {

    public static void printRaceRoundResults(String name, int count) {
        System.out.println(name + " : " + "-".repeat(count));
    }

    public static void printFinalWinner(String result) {
        System.out.println(result);
    }
}
