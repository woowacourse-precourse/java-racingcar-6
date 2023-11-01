package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class Move {


    public int picknum(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void random_move(Car car){
        if(picknum()>3)
            car.movecar();
    }


    public static void draw(Car car){
        for(int i=0; i<car.position; i++) {
            System.out.printf("-");
        }
        System.out.println("");
    }


}
