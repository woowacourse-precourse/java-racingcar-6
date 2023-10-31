package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Judgement {
    public static boolean moveForward() {
        int number = Randoms.pickNumberInRange(0, 9);

        return number >= 4;

    }

    public static ArrayList<Integer> playerMoveForward(ArrayList<Integer> gameResult) {
        for (int i=0; i < gameResult.size(); i++) {
            if (moveForward()) {
                int element = gameResult.get(i);
                element += 1;
                gameResult.set(i, element);
            }
        }
        return gameResult;
    }
}
