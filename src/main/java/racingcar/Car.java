package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int distance=0;


    public Car( String name) {
        this.name=name;
    }

    int drive_random(){
        if(Randoms.pickNumberInRange(0,9)>=4){
            distance+=1;
        };
        return distance;
    }
}
