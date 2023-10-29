package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

// TODO : 예외 입히기
public final class UserInput {
    public static String[] racingCarsName() {
        return Console.readLine().trim().split(",");
    }

    public static Integer racingTimes() {
        return Integer.parseInt(Console.readLine());
    }
}
