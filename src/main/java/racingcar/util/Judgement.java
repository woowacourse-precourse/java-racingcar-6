package racingcar.util;

import racingcar.domain.Car;

public class Judgement {
    private static final int JUDGEMENT_NUMBER = 4;

    public static void judgeNumberToGo(int number, Car car) {
        if (number >= JUDGEMENT_NUMBER) {
            car.go();
        }
    }
}