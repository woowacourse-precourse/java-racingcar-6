package racingcar.view;

import racingcar.common.constant.GuidePhrases;
import racingcar.domain.entity.CarEntity;

import java.sql.SQLOutput;
import java.util.List;

public class OutputAboutGame {
    public static void PrintCarInputPhrase() {
        System.out.println(GuidePhrases.carInputPhrase);
    }

    public static void PrintAttemptInputPhrase() {
        System.out.println(GuidePhrases.attemptInputPhrase);
    }

    public static void PrintResultIntroducePhrase() {
        System.out.println();
        System.out.println(GuidePhrases.reselutPhrase);
    }

    public static void PrintCurrentSituation(List<CarEntity> cars) {
        for (CarEntity car : cars) {
            System.out.printf("%s : ", car.getCarName());
            PrintScore(car.getPosition());
        }
        System.out.println();
    }

    public static void PrintScore(int position) {
        for (int i = 0; i < position; i++) {
            System.out.printf("-");
        }
        System.out.println();
    }

    public static void PrintWinner(List<CarEntity> winners) {
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
