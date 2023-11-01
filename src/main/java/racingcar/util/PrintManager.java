package racingcar.util;

import racingcar.domain.Car;

import java.util.List;

public class PrintManager {

    public static void printInputCarName() {
        System.out.println(MessageEnum.INPUT_START_MESSAGE.getMessage());
    }

    public static void printInputTryTimes() {
        System.out.println(MessageEnum.INPUT_TRY_MESSAGE.getMessage());
    }

    public static void printPlayResultStart() {
        System.out.println(MessageEnum.PLAY_RESULT.getMessage());
    }

    public static void printGameResult(Car car) {
        System.out.print(car.getName() + " : ");
        for(int i = 0 ; i < car.getLocation(); i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printSeparateStage() {
        System.out.println();
    }

    public static void printFinalResult(List<Car> winnerList) {
        System.out.print(MessageEnum.FINAL_WINNER.getMessage());
        for(int i = 0 ; i < winnerList.size() -1; i++) {
            System.out.print(winnerList.get(i).getName() + ", ");
        }
        System.out.println(winnerList.get(winnerList.size() -1).getName());

    }


}
