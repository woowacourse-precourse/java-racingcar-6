package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Move {

    public int picknum(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void random_move(){
        if(picknum()>3)
            movecar();
    }

    public static void movecar(){
        System.out.printf("-");
    }

}
