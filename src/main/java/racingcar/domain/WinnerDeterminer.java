package racingcar.domain;

import java.util.List;

/** Car 클래스의 요소 중 승자를 탐색 */
public class WinnerDeterminer {
    public static String winner(List<Car> cars) {
        int winnerScore = getWinnerScore(cars);
        return winnerName(cars, winnerScore);
    }

    private static String winnerName(List<Car> cars, int winnerScore) {
        String winners = "";
        for (Car car : cars) {
            if (car.position < winnerScore)
                continue;
            if (!winners.isEmpty()) {
                winners += ", ";
            }
            winners += car.name;
        }
        return winners;
    }

    // 승자의 점수, 즉 최대 점수를 찾기
    private static int getWinnerScore(List<Car> cars) {
        int max = -1;
        for (Car car : cars) {
            if (car.position > max) {
                max = car.position;
            }
        }
        return max;
    }
}
