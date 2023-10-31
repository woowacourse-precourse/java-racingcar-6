package racingcar.iosystem;

import java.util.Arrays;
import java.util.StringJoiner;

public class OutputView {
    public static void printExecutionResult(String[] cars, int[] carMove) {
        System.out.println("실행 결과");
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i] + " : " + "-".repeat(carMove[i]));
        }
    }

    public static void endGameResult(int[] carMove, String[] cars) {
        System.out.print("최종 우승자 : ");
        System.out.println(winnerCarsList(carMove, cars));
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

    public static void printCarList(String[] carList) {
        String printCommaCar = String.join(",",carList);
        System.out.println(printCommaCar);
    }

    public static void printCntInt(int cntInt) {
        System.out.println(cntInt);
        System.out.println();
    }
    public static String winnerCarsList(int[] carMove, String[] cars) {
        return String.join(", ", countWinner(carMove, cars));
    }

    public static String[] countWinner(int[] carMove, String[] cars) {
        int maxValue = Arrays.stream(carMove).max().getAsInt();
        int occurrences = countOccurrences(carMove, maxValue);
        String[] winnerCars = new String[occurrences];
        int cnt = 0;
        for (int i = 0; i < cars.length; i++) {
            if (carMove[i] == maxValue) {
                winnerCars[cnt] = cars[i];
                cnt++;
            }
        }
        return winnerCars;
    }
}
