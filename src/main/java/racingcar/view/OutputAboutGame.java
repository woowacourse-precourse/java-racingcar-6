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
}
