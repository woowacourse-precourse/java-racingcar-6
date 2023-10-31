package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import racingcar.model.Car;

public class GoStop {

    private static final int FORWARD_BOUND = 4;

    public static void oneTurn(List<Car> Users) {
        for (Car user: Users) {
            if(decisionMaker(generateNum())) {
                user.forward();
            }
        }
    }
    private static boolean decisionMaker(int n) {
        return n >= FORWARD_BOUND;
    }
    private static int generateNum() {
        return Randoms.pickNumberInRange(0,9);
    }



}
