package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;

public class Racing {
    private static final int RANDOM_RANGE_MIN_NUMBER = 0;
    private static final int RANDOM_RANGE_MAX_NUMBER = 9;
    private static final int RANDOM_NUMBER_LIMIT_LENGTH = 4;

    ArrayList<Integer> playerResult = new ArrayList<>();
    Input input;

    public Racing(Input input) {
        this.input = input;
    }

    public int selectNumber() {
        int pickNumber = Randoms.pickNumberInRange(RANDOM_RANGE_MIN_NUMBER, RANDOM_RANGE_MAX_NUMBER);
        return pickNumber;
    }

    public boolean verifyNumber(int pickNumber) {
        if (pickNumber >= RANDOM_NUMBER_LIMIT_LENGTH) {
            return true;
        }
        return false;
    }

    public void setPlayerResult() {
        for (int i = 0; i < input.getPlayerName().size(); i++) {
            playerResult.add(0);
        }
    }

    public ArrayList<Integer> getPlayerResult() {
        return playerResult;
    }

    public void movePlayer(boolean move, int playerNumber) {
        if (move) {
            playerResult.set(playerNumber, playerResult.get(playerNumber) + 1);
        }
    }

    public ArrayList<Integer> goalPlayer() {
        int max = Collections.max(playerResult);
        ArrayList<Integer> goalNumber = new ArrayList<>();
        for (int i = 0; i < playerResult.size(); i++) {
            if (playerResult.get(i) == max) {
                goalNumber.add(i);
            }
        }
        return goalNumber;
    }

    //랜덤으로 뽑은 숫자를 검증하여 움직이는 코드
    public void startRacing(int playerNumber) {
        movePlayer(verifyNumber(selectNumber()), playerNumber);
    }

}
