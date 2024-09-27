package racingcar.view;

import racingcar.common.constant.GuidePhrases;
import racingcar.domain.entity.CarEntity;

import java.util.List;

public class OutputAboutGame {
    public static void printCarInputPhrase() {
        System.out.println(GuidePhrases.carInputPhrase);
    }

    public static void printAttemptInputPhrase() {
        System.out.println(GuidePhrases.attemptInputPhrase);
    }

    public static void printResultIntroducePhrase() {
        System.out.println();
        System.out.println(GuidePhrases.reselutPhrase);
    }

    public static void printCurrentSituation(List<CarEntity> cars) {
        for (CarEntity car : cars) {
            System.out.printf("%s : ", car.getCarName());
            printScore(car.getPosition());
        }
        System.out.println();
    }

    public static void printScore(int position) {
        for (int i = 0; i < position; i++) {
            System.out.printf("-");
        }

        System.out.println();
    }

    public static void printWinner(List<CarEntity> winners) {
        StringBuilder winnerStringList = new StringBuilder();

        System.out.printf("%s : ", GuidePhrases.introduceWinnerPhrase);

        for (CarEntity winner : winners) {
            winnerStringList.append(winner.getCarName());
            winnerStringList.append(", ");
        }

        winnerStringList.deleteCharAt(winnerStringList.length() - 1);
        winnerStringList.deleteCharAt(winnerStringList.length() - 1);
        System.out.println(winnerStringList);
    }
}
