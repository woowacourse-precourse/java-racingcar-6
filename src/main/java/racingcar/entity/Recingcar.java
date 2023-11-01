package racingcar.entity;
import camp.nextstep.edu.missionutils.Randoms;

public class Recingcar {
    // 자동차 이름
    String name;
    //전진 횟수, 이번 랜덤 값
    int moveCnt, randomNum;

    public Recingcar(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRandomNum() {
        return randomNum;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public void setMoveCnt(int moveCnt) {
        this.moveCnt = moveCnt;
    }

    public void setRandomNum() {
        this.randomNum = Randoms.pickNumberInRange(0, 9);
    }
}