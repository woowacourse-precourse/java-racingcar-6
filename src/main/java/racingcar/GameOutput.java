package racingcar;

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
        List<Integer> maxCarPositionIndex = carList.findMaxCarPositionIndex();
        String maxCarPositionName;

        System.out.printf("최종 우승자 : ");
        for (int index = 0; index < maxCarPositionIndex.size(); index++) {
            if (index >= 1) {
                System.out.printf(", ");
            }
            maxCarPositionName = carList.getName(maxCarPositionIndex.get(index));
            System.out.printf(maxCarPositionName);
        }

    }

}