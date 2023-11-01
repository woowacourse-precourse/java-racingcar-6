package racingcar;

import java.util.ArrayList;

public class Judgement {
    public static boolean moveForward() {
        int number = NumberGenerator.createRandomNumber();
        return number >= 4;
    }

    public static ArrayList<Integer> playerMoveForward(ArrayList<Integer> gameResult) {
        int element;
        for (int i=0; i < gameResult.size(); i++) {
            if (moveForward()) {
                element = gameResult.get(i) + 1;
                gameResult.set(i, element);
            }
        }
        return gameResult;
    }
}
