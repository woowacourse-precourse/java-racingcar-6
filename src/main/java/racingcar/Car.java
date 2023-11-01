package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class Car {

    private String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int ismove = Randoms.pickNumberInRange(0,9);
        if(ismove >= 4){
            position++;
        }
    }

    public void printPostion(){
        System.out.print(name+" : ");
        for(int i =0; i< position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName(){
        return name;
    }
    public int getPosition(){
        return  position;
    }
}
