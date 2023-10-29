package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    private static String[] carList;
    private static int[] gameResultCount;
    private static int carListLength;
    private static int winCount;

    public static void moveCar() {
        for (int i = 0; i < carListLength; i++) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                gameResultCount[i]++;
            }
        }
    }

    public static void playGame(String[] inputCarList, int playCount) {
        carList = inputCarList;
        carListLength = carList.length;
        gameResultCount = new int[carListLength];

        System.out.println("\n실행 결과");
        for (int i = 0; i < playCount; i++) {
            moveCar();
        }
    }
}
