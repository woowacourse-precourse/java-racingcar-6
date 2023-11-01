package racingcar.entity;
import camp.nextstep.edu.missionutils.Randoms;

public class Recingcar {
    // 자동차 이름
    String name, moveString;
    //전진 횟수, 이번 랜덤 값
    int randomNum, moveCnt;

    public Recingcar(String name){
        this.name = name;
        this.moveString ="";
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
    public String getMoveString() {
        return moveString;
    }


    public void setMoveString(String moveString) {
        this.moveString += moveString;
    }

    public void setRandomNum() {
        this.randomNum = Randoms.pickNumberInRange(0, 9);
    }
}