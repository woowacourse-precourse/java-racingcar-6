package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingGame {

    private static String[] carList;
    private static int[] gameResultCount;
    private static int carListLength;
    private static int winCount;
    private static ArrayList<String> winningCarList = new ArrayList<>();

    public static void countWinningCar() {
        for (int i = 0; i < carListLength; i++) {
            if (winCount == gameResultCount[i]) {
                winningCarList.add(carList[i]);
            }
        }
    }

    public static void printMoveResult(String carName, int moveCount) {
        System.out.print(carName + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public static void moveCar() {
        for (int i = 0; i < carListLength; i++) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                gameResultCount[i]++;
                winCount = Math.max(winCount, gameResultCount[i]);
            }
            printMoveResult(carList[i], gameResultCount[i]);
        }
        System.out.print("\n");
    }

    public static void playGame(String[] inputCarList, int playCount) {
        carList = inputCarList;
        carListLength = carList.length;
        gameResultCount = new int[carListLength];

        System.out.println("\n실행 결과");
        for (int i = 0; i < playCount; i++) {
            moveCar();
        }

        countWinningCar();
    }
}
