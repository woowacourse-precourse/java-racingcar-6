package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 자동차
 */
public class Racingcar implements Comparable<Racingcar>{
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

    /**
     * 0~9 사이의 무작위 값을 구하여 전진 여부 결정
     */
    public void decideMove(){
        int randomNumber = Randoms.pickNumberInRange(Constant.GENERATE_MIN_VALUE, Constant.GENERATE_MAX_VALUE);
        if (randomNumber>=Constant.ENABLE_MOVE_VALUE){
            moveCount += 1;
        }
    }

    /**
     * 전진 횟수로 내림차순 비교 - 우승자 결정에 활용
     */
    @Override
    public int compareTo(Racingcar o) {
        return o.getMoveCount()-this.getMoveCount();
    }
}
