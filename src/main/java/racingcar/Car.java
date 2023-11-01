package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int move;
    public Car(String name){
        this.name = name;
        this.move = 0;
    }

    public String getName(){
        return this.name;
    }
    public int getMove(){
        return this.move;
    }

    public void makeMove(){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            this.move++;
        }
    }

    public void drawMove(){
        for(int i = 0; i < move; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
