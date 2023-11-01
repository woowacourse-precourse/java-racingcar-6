package racingcar.global.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.constant.CommonNumberType;

import java.util.List;

public class ConsoleUtil {
    private ConsoleUtil() {

    }

    public static String input() {
        return Console.readLine();
    }

    public static void commonOutputLine(String output) {
        System.out.println(output);
    }

    public static void commonOutput(String output) {
        System.out.print(output);
    }

    public static void lineOutput() {
        System.out.println();
    }

    public static void resultTitleOutput() {
        System.out.println("실행 결과");
    }

    public static void distanceOutput(List<String> nameList, List<Integer> roundDistance) {
        for (int index = 0; index < nameList.size(); index++) {
            System.out.println(nameList.get(index) + " : " + "-".repeat(roundDistance.get(index)));
        }
    }

    public static void excutionResultOutput(List<Integer> maxIndices,List<String> nameList) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < maxIndices.size(); i++) {
            System.out.print(nameList.get(maxIndices.get(i)));
            if (i < maxIndices.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static boolean isGameEnd(int numberOfGames, int currentRound) {
        return currentRound == numberOfGames;
    }
}
