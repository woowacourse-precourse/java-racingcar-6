package racingcar.dto;

/*
 *   입력받는 이동 횟수 정보를 담당
 * */

public class MoveCount {
    private int count;

    public MoveCount(int moveCount) {
        this.count = moveCount;
    }

    public int getMoveCount() {
        return count;
    }
}
