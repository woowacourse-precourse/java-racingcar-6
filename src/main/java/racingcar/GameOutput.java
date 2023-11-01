package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameOutput {

    public static void printRaceProgress(CarList racingCarList) {
        for (int carIndex = 0; carIndex < racingCarList.getSize(); carIndex++) {
            System.out.print(racingCarList.getName(carIndex) + " : ");
            for (int carPosition = 0; carPosition < racingCarList.getPosition(carIndex); carPosition++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        return;
    }

    public static void printWinners(CarList carList) {
        int[] maxCarPositionIndex = findMaxCarPositionIndex(carList);
        String maxCarPositionName;

        System.out.printf("최종 우승자 : ");
        for (int index = 0; index < maxCarPositionIndex.length; index++) {
            if (index >= 1) {
                System.out.printf(", ");
            }
            maxCarPositionName = carList.getName(maxCarPositionIndex[index]);
            System.out.printf(maxCarPositionName);
        }

    }

    private static int[] findMaxCarPositionIndex(CarList carList) {
        int carPosition;
        int maxCarPosition = -1;
        List<Integer> maxCarPositionIndex = new ArrayList<>();

        for (int index = 0; index < carList.getSize(); index++) {
            carPosition = carList.getPosition(index);
            if (maxCarPosition == carPosition) {
                maxCarPositionIndex.add(index);
            } else if (maxCarPosition < carPosition) {
                maxCarPosition = carPosition;
                maxCarPositionIndex.clear();
                maxCarPositionIndex.add(index);
            }
        }
        return ListToIntArray(maxCarPositionIndex);
    }

    public static int[] ListToIntArray(List<Integer> intList) {
        int[] intArray = new int[intList.size()];
        for (int index = 0; index < intArray.length; index++) {
            intArray[index] = intList.get(index);
        }
        return intArray;
    }
    
}