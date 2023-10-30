package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayGame extends CarNameInput {
    List<Integer> moveCount;


    PlayGame() {
        for (int i = 0; i < nameList.size(); i++) {
            moveCount.add(0);
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void simulation() {
        int go=4;
        for (int i = 0; i < moveCount.size(); i++) {
            if (getRandomNumber() >= go) moveCount.set(i, moveCount.get(i) + 1);
        }
    }


}
