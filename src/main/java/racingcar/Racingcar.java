package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 자동차
 */
public class Racingcar {
    private String name; // 이름
    private int moveCount; // 전진 횟수

    public Racingcar(String name){
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
