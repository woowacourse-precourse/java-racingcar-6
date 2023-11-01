package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public void PlusScore(){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            position ++;
        }
    }

    public void PrintPosition(){
        System.out.print(name + " : ");
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }
}
