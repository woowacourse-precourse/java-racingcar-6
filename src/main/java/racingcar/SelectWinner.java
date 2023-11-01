package racingcar;

import java.util.ArrayList;
import java.util.List;

public class SelectWinner {
    static private List<String> winners;
    static void selectWinner(Car[] carArr) {
        int max = 0;
        winners = new ArrayList<String>();
        for (Car car: carArr) {
            if (car.score > max) {
                max = car.score;
                winners.clear();
                winners.add(car.name);
            } else if (car.score == max) {
                winners.add(car.name);
            }
        }
    }

    static void printWinner() {
        String answer = winners.get(0);
        if (winners.size() > 1) {
            for (int idx = 1; idx < winners.size(); idx++) {
                answer = answer + ", " + winners.get(idx);
            }
        }
        System.out.printf("최종 우승자 : %s", answer);
    }

    public static List<String> getWinners() {
        return winners;
    }

    public static void setWinners(List<String> winners) {
        SelectWinner.winners = winners;
    }
}
