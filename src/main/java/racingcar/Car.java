package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    String carName;
    Integer distance = 0;

    public Car(String name){
        this.carName = name;
    }

    public void decideIfCarShouldGo(){
        int randInt = pickNumberInRange(0,9);
        if (randInt >= 4){
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public void printCurrentDistance(){
        System.out.printf("%s : ", this.carName);
        for(int i=0; i<this.distance; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
