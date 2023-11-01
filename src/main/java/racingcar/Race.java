package racingcar;

public class Race {
    public static void excute(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            printRoundResults(carNames, positions, i);
        }
    }

    private static void printRoundResults(String[] carNames, int[] positions, int i) {
        System.out.print(carNames[i] + " : ");
        for (int j = 0; j < positions[i]; j++) {
            System.out.print("-");
        }
    }
}
