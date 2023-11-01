package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int moveCount = 0;
    private String name= "";

    public Car(String name) {
        this.name = name;
    }

    public void tryToMove(){
        if (compare(generateRandomNumber())){
            moveCount++;
        }
    }

    private int generateRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
    private boolean compare(int x){
        return x >=4;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
