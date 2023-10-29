package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int distance = 0;

    public Car(String carName){
        this.carName = carName;
    }

    public void run(){
        if(Randoms.pickNumberInRange(0, 9) >=4){
            distance++;
        }
    }

    public void printState(){
        System.out.print(carName+" : ");
        for(int i=0;i<distance;i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public String getCarName(){
        return carName;
    }
    public int getDistance(){
        return distance;
    }

}
