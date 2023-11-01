package racingcar;

import static racingcar.Application.cars;
import static racingcar.Application.winners;

public class RacingResult {
    private static int getMaxScore() {
        int max = 0;
        int countPerson = 0;
        for (Car car : cars) {
            max = setMaxScore(max,car.getDriveNum());
        }
        return max;
    }
    private static int setMaxScore(int max, int driveNum) {
        if (max < driveNum)
            max = driveNum;
        return max;
    }
    private static boolean decideWinner(int max) {
        boolean isSolo = true;
        int countPerson = 0;
        for (Car car : cars) {
            if (max == car.getDriveNum()) {
                winners.add(car.getName());
                countPerson++;
            }
        }
        if (countPerson > 1) isSolo = false;
        return isSolo;
    }
    public static void showWinner() {
        boolean isSolo = decideWinner(getMaxScore());
        if (isSolo) {
            System.out.println(MessageUtil.MSG_FINAL_WINNER+ winners.get(0));
        } else {
            String winnerNames = String.join(", ",winners);
            System.out.println(MessageUtil.MSG_FINAL_WINNER+winnerNames);
        }
    }
}