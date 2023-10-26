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
        String input = Console.readLine();
        String[] playerArr = input.split(",");
        for (int i = 0; i < playerArr.length; i++) {
            if (playerArr[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int repeatNum = Integer.parseInt(Console.readLine());

        Car[] cars = new Car[playerArr.length];
        for (int i = 0; i < playerArr.length; i++) {
            cars[i] = new Car(playerArr[i]);
        }
        System.out.println("실행 결과");
        for (int i = 0; i < repeatNum; i++) {
            for (int j = 0; j < playerArr.length; j++) {
                cars[j].forward(RandomNumberGenerator.randomNumber());
                System.out.println(playerArr[j]+" : " + cars[j].getGameProgressByHyphens());
            }
            System.out.println();
        }
        int[] total = new int[playerArr.length];
        for (int i = 0; i < playerArr.length; i++) {
            total[i] = cars[i].getGameProgress();
        }
        int[] winners = getIndicesOfMaxValues(total);
        System.out.print("최종 우승자 : ");
        System.out.print(playerArr[winners[0]]);
        if (winners.length != 1) {
            for (int i = 1; i < winners.length; i++) {
                System.out.print(", ");
                System.out.print(playerArr[winners[i]]);
            }
        }
    }
    public static int[] getIndicesOfMaxValues(int[] array) {
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
