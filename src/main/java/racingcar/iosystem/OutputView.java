package racingcar.iosystem;

import java.util.Arrays;

public class OutputView {
    public static void printExecutionResult(String[] cars, int[] carMove) {
        System.out.println("실행결과");
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i] + " : ");
            for (int j = 0; j < carMove[i]; j++) {
                System.out.print('-');
            }
            System.out.println();
        }
    }

    public static void endGameResult(int[] carMove, String[] cars) {
        System.out.print("최종 우승자 : ");
        int maxValue = Arrays.stream(carMove).max().getAsInt();
        int occurrences = countOccurrences(carMove, maxValue);
        for (int i = 0; i < cars.length; i++) {
            if (carMove[i] == maxValue) {
                System.out.print(cars[i]);
                commaMade(--occurrences);

            }
        }
    }
    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int value : arr) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    private static void commaMade(int occurrences) {
        if (occurrences != 0) {
            System.out.print(", ");
        }
    }
}
