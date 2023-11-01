package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int moveCount = 0;

    public void tryToMove(){
        if (compare(generateRandomNumber())){
            moveCount++;
        }
    }

    public int generateRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
    public boolean compare(int x){
        return x >=4;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
