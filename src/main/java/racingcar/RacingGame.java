package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingGame {

    private final ArrayList<String> winningCarList;
    private final String[] carList;
    private final int carListLength;
    private final int playCount;
    private final int[] gameResultCount;
    private int winCount;

    public RacingGame(String[] inputCarList, int inputPlayCount) {
        winningCarList = new ArrayList<>();
        carList = inputCarList;
        carListLength = carList.length;
        playCount = inputPlayCount;
        gameResultCount = new int[carListLength];
        winCount = 0;
    }

    public void printWinningCar() {
        System.out.print("최종 우승자 : " + String.join(", ", winningCarList));
    }

    public void countWinningCar() {
        for (int i = 0; i < carListLength; i++) {
            if (winCount == gameResultCount[i]) {
                winningCarList.add(carList[i]);
            }
        }
    }

    public void printMoveResult(String carName, int moveCount) {
        System.out.print(carName + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public void moveCar() {
        for (int i = 0; i < carListLength; i++) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                gameResultCount[i]++;
                winCount = Math.max(winCount, gameResultCount[i]);
            }
            printMoveResult(carList[i], gameResultCount[i]);
        }
        System.out.print("\n");
    }

    public void playGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < playCount; i++) {
            moveCar();
        }

        countWinningCar();
        printWinningCar();
    }
}
