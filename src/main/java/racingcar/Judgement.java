package racingcar;

import java.util.ArrayList;

public class Judgement {
    public static boolean moveForward() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int number = numberGenerator.createRandomNumber();

        if (number >= 4) {
            return true;
        } else {
            return false;
        }

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
