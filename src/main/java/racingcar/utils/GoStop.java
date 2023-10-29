package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import main.java.racingcar.model.Car;

public class GoStop {

    private static final int FORWARD_BOUND = 4;
    public static void decideGoStop (Car car) {
        car.forward();
    }
    private static boolean decisionMaker(int n) {
        return n >= FORWARD_BOUND;
    }
    private static int generateNum() {
        int num;
        return num = Randoms.pickNumberInRange(0,9);
    }



}
