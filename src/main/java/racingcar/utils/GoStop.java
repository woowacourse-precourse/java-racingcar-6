package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import main.java.racingcar.model.Car;

public class GoStop {

    public static void decideGoStop (Car car) {
        car.forward();
    }
    private static boolean decisionMaker(int n) {
        return n >= 4;
    }
    private static int generateNum() {
        int num;
        return num = Randoms.pickNumberInRange(0,9);
    }



}
