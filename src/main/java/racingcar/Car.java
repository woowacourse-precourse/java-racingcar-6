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
}
