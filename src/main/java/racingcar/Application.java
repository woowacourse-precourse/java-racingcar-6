package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = getInput();
        String[] playerArr = nameSplit(input);
        isStrLenOutOfRange(playerArr);
        System.out.println("시도할 회수는 몇회인가요?");
        int repeatNum = Integer.parseInt(getInput());

        Car[] cars = new Car[playerArr.length];
        carToCarsArr(playerArr, cars);

        printGameResult(repeatNum, playerArr, cars);

        int[] total = new int[playerArr.length];
        totalGameProgress(playerArr, total, cars);

        int[] winners = getIndicesOfMaxValues(total);
        printWinners(playerArr, winners);
    }

    static void carToCarsArr(String[] playerArr, Car[] cars) {
        for (int i = 0; i < playerArr.length; i++) {
            cars[i] = new Car(playerArr[i]);
        }
    }

    static void totalGameProgress(String[] playerArr, int[] total, Car[] cars) {
        for (int i = 0; i < playerArr.length; i++) {
            total[i] = cars[i].getGameProgress();
        }
    }

    static void printGameResult(int repeatNum, String[] playerArr, Car[] cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < repeatNum; i++) {
            for (int j = 0; j < playerArr.length; j++) {
                cars[j].forward(RandomNumberGenerator.randomNumber());
                System.out.println(playerArr[j]+" : " + cars[j].getGameProgressByHyphens());
            }
            System.out.println();
        }
    }

    static void printWinners(String[] playerArr, int[] winners) {
        System.out.print("최종 우승자 : ");
        System.out.print(playerArr[winners[0]]);
        if (winners.length != 1) {
            for (int i = 1; i < winners.length; i++) {
                System.out.print(", ");
                System.out.print(playerArr[winners[i]]);
            }
        }
    }

    static String[] nameSplit(String input) {
        String[] playerArr = input.split(",");
        return playerArr;
    }

    static String getInput() {
        return Console.readLine();
    }

    static void isStrLenOutOfRange(String[] playerArr) {
        for (int i = 0; i < playerArr.length; i++) {
            if (playerArr[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    static int[] getIndicesOfMaxValues(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("배열이 비어 있거나 null입니다.");
        }

        int maxIndex = 0;
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }

        List<Integer> maxIndexList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxValue) {
                maxIndexList.add(i);
            }
        }

        int[] maxIndices = new int[maxIndexList.size()];
        for (int i = 0; i < maxIndexList.size(); i++) {
            maxIndices[i] = maxIndexList.get(i);
        }

        return maxIndices;
    }
}
